package Mk.JD2_95_22.fitness.servise.user;

import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserLogin;
import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;
import Mk.JD2_95_22.fitness.core.exeption.SingleError;
import Mk.JD2_95_22.fitness.core.util.UserRole;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.StatusEntity;
import Mk.JD2_95_22.fitness.orm.repository.IPersonalUserRepository;
import Mk.JD2_95_22.fitness.security.util.JwtUtils;
import Mk.JD2_95_22.fitness.servise.api.mail.IEmailSenderService;
import Mk.JD2_95_22.fitness.servise.api.user.IAppUserService;
import Mk.JD2_95_22.fitness.servise.api.user.IUserService;
import Mk.JD2_95_22.fitness.servise.my_exeption.user.UserValidateExeption;
import Mk.JD2_95_22.fitness.servise.validation.UserRegistrationValidator;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public class AppUserService implements IAppUserService {
    private final IPersonalUserRepository repository;
    private final IUserService service;
    private final IEmailSenderService emailService;
    private final  ConversionService conversionService;
    private  final BCryptPasswordEncoder encoder;
    private  final UserRegistrationValidator validator;
    private final JwtUtils generateAccessToken;

    public AppUserService(IPersonalUserRepository repository, IUserService service, IEmailSenderService emailService, ConversionService conversionService, BCryptPasswordEncoder encoder, UserRegistrationValidator validator, JwtUtils generateAccessToken) {
        this.repository = repository;
        this.service = service;
        this.emailService = emailService;
        this.conversionService = conversionService;
        this.encoder = encoder;
        this.validator = validator;
        this.generateAccessToken = generateAccessToken;
    }

    public void create(UserRegistration user) {
        validator.validate(user);
        service.CreatedUser(new UserCreated(
                UUID.randomUUID(),
                Instant.now(),
                Instant.now(),
                user.getFIOuser(),
                user.getMailUser(),
                user.getPassword(),
                UserRole.USER,
                UserStatus.WAITING_ACTIVATION));
        UserEntity userEntity = find(user.getMailUser());
        String code = UUID.randomUUID().toString();
        userEntity.setCode(code);
        repository.save(userEntity);
        emailService.sendActiveMail("maksim.maks.23@mail.ru", code,
                "Hello, confirm verification");
    }


    public void verify(String code,String mail) {
        UserEntity userEntity = find(mail);

        if(code.equals(userEntity.getCode())){
            userEntity.setStatus(new StatusEntity(UserStatus.ACTIVATED));
            userEntity.setCode(null);
            repository.save(userEntity);
        } else throw new UserValidateExeption("Incorrect mail and code");
    }

    public String login(@Validated UserLogin user) {
        UserEntity userEntity = find(user.getMailUser());
        if(!encoder.matches(user.getPassword(),userEntity.getPassword())){
            throw new UserValidateExeption("Incorrect mail and password");
        }
        return generateAccessToken.generateJwtToken( userEntity );
    }

    public UserEntity find(String mail){
        if(mail==null||mail.isBlank()){
            new SingleError("User with this mail is not registered");
        }
        return repository.findByMail(mail);
    }


    public UserDTO getCard(UUID uuid) {
        Optional<UserEntity> findUserEntity = repository.findByUuid(uuid);
        if(findUserEntity.isEmpty()){
            throw new SingleError("Пользователя с id " + uuid + " нет базе данных!");
        }
        UserEntity userEntity = findUserEntity.get();
        return conversionService.convert(userEntity, UserDTO.class);
    }

}
