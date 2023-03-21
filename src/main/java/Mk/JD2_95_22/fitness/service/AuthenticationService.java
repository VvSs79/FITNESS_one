package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.dto.erorr.SingleErrorResponse;
import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.user.UserAddDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreate;
import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.user.UserNotFoundExeption;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.user.UserValidateExeption;
import Mk.JD2_95_22.fitness.core.exception.validation.UserRegistrationValidator;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import Mk.JD2_95_22.fitness.service.api.mail.IEmailService;
import Mk.JD2_95_22.fitness.service.api.user.IAuthenticationService;
import Mk.JD2_95_22.fitness.service.api.user.IUserService;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.check_exeptions.DoubleException;
import Mk.JD2_95_22.fitness.orm.repository.user.IAuthenticationUserRepository;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserStatus;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import java.util.Optional;
import java.util.UUID;

public class AuthenticationService implements IAuthenticationService {

    private final IAuthenticationUserRepository repository;
    private final ConversionService conversionService;
    private final IEmailService emailService;
    private final IUserService iUserService;
    private final UserRegistrationValidator validator;

    public AuthenticationService(IAuthenticationUserRepository repository, ConversionService conversionService,
                                 IEmailService emailService, IUserService iUserService,
                                 UserRegistrationValidator validator) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.emailService = emailService;
        this.iUserService = iUserService;
        this.validator = validator;
    }

    public UserJsonModel logIn(UserLogin userLogin) {
        UserEntity userEntity = repository.findByMail(userLogin.getMail());
        if(userEntity==null){
            throw new UserNotFoundExeption("User not found");
        }
        try {
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            encoder.matches(userLogin.getPassword(), userEntity.getPassword());
        }catch (RuntimeException e) {
            throw new UserValidateExeption("Incorrect parameters");
        }
        return conversionService.convert(userEntity, UserJsonModel.class);
    }


    @Override
    public void registration(UserRegistration userRegistration) {
        UserEntity userEntity = repository.findByMail(userRegistration.getMail());
        if (userEntity != null) {
            throw new DoubleException("User this is a mail is exist");
        } else {
            validator.validate(userRegistration);
            iUserService.create(new UserCreate(userRegistration.getMail(),
                    userRegistration.getFio(),
                    userRegistration.getPassword()));
            UUID code = UUID.randomUUID();
            userEntity = repository.findByMail(userRegistration.getMail());
            userEntity.setCode(code.toString());
            repository.save(userEntity);
            emailService.sendSimpleEmail(userRegistration.getMail(), "Verification", code.toString());
        }
    }

    @Override
    public void verification(String code, String mail) {
        UserEntity userEntity = repository.findByMail(mail);
        if (userEntity != null && code.equals(userEntity.getCode())) {
            userEntity.setStatus(new StatusEntity((UserStatus.ACTIVATED)));
            userEntity.setCode(null);
            repository.save(userEntity);
        } else throw new UserNotFoundExeption("User not found");
    }

    @Override
    public UserAddDTO getCard(UUID uuid) {
        Optional<UserEntity> findUserEntity = repository.findById(uuid);
        if(findUserEntity.isEmpty()){
            try {
                throw new SingleErrorResponse("structured_error","User with this " + uuid + " is not registered");
            } catch (SingleErrorResponse e) {
                throw new RuntimeException(e);
            }
        }
        UserEntity userEntity = findUserEntity.get();
        return conversionService.convert(userEntity, UserAddDTO.class);
    }
}
