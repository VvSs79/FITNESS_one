package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.dto.erorr.SingleErrorResponse;
import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.user.*;
import Mk.JD2_95_22.fitness.core.exception.user.UserNotFoundExeption;
import Mk.JD2_95_22.fitness.core.exception.user.UserValidateExeption;
import Mk.JD2_95_22.fitness.core.exception.validation.ValidationExeption;
import Mk.JD2_95_22.fitness.service.validate.UserRegistrationValidator;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import Mk.JD2_95_22.fitness.service.api.mail.IEmailService;
import Mk.JD2_95_22.fitness.service.api.user.IAuthenticationService;
import Mk.JD2_95_22.fitness.service.api.user.IUserService;
import Mk.JD2_95_22.fitness.core.exception.check_exeptions.DoubleException;
import Mk.JD2_95_22.fitness.orm.repository.user.IAuthenticationUserRepository;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.json.JSONException;
import org.json.JSONObject;



import java.util.Optional;
import java.util.UUID;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AuthenticationService implements IAuthenticationService {
//    @Value("${spring.data.redis.urlemail}")
    private String url;
    private final IAuthenticationUserRepository repository;
    private final ConversionService conversionService;
    private final IEmailService emailService;
    private final IUserService iUserService;
    private final UserRegistrationValidator validator;
    private final PasswordEncoder encoder;

    public AuthenticationService(IAuthenticationUserRepository repository,
                                 ConversionService conversionService,
                                 IEmailService emailService,
                                 IUserService iUserService,
                                 UserRegistrationValidator validator,
                                 PasswordEncoder encoder) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.emailService = emailService;
        this.iUserService = iUserService;
        this.validator = validator;
        this.encoder = encoder;
    }

//    public UserJsonModel logIn(UserLogin userLogin) {
//        UserEntity userEntity = repository.findByMail(userLogin.getMail().toLowerCase());
//        if(userEntity==null){
//            throw new UserNotFoundExeption("User not found");
//        }
//        try {
////            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//            encoder.matches(userLogin.getPassword(), userEntity.getPassword());
//        }catch (RuntimeException e) {
//            throw new UserValidateExeption("Incorrect parameters");
//        }
//        return conversionService.convert(userEntity, UserJsonModel.class);
//    }
//
//
//    @Override
//    public void registration(UserRegistration userRegistration) {
//        UserEntity userEntity = repository.findByMail(userRegistration.getMail());
//        if (userEntity != null) {
//            throw new DoubleException("User this is a mail is exist");
//        } else {
//            validator.validate(userRegistration);
//            iUserService.create(new UserCreate(userRegistration.getMail(),
//                    userRegistration.getFio(),
//                    userRegistration.getPassword()));
//            UUID code = UUID.randomUUID();
//            userEntity = repository.findByMail(userRegistration.getMail());
//            userEntity.setCode(code.toString());
//            repository.save(userEntity);
//            emailService.sendSimpleEmail(userRegistration.getMail(), "Verification", code.toString());
//        }
//    }
//
//    @Override
//    public void verification(String code, String mail) {
//        UserEntity userEntity = repository.findByMail(mail);
//        if (userEntity != null && code.equals(userEntity.getCode())) {
//            userEntity.setStatus(new StatusEntity((UserStatus.ACTIVATED).ordinal(),(UserStatus.ACTIVATED)));
//            userEntity.setCode(null);
//            repository.save(userEntity);
//        } else throw new UserNotFoundExeption("User not found");
//    }
//
//    @Override
//    public UserAddDTO getCard(UUID uuid) {
//        Optional<UserEntity> findUserEntity = repository.findById(uuid);
//        if(findUserEntity.isEmpty()){
//            try {
//                throw new SingleErrorResponse("structured_error","User with this " + uuid + " is not registered");
//            } catch (SingleErrorResponse e) {
//                throw new RuntimeException(e);
//            }
//        }
//        UserEntity userEntity = findUserEntity.get();
//        return conversionService.convert(userEntity, UserAddDTO.class);
//    }
public UserJsonModel logIn(UserLogin user) {
    UserEntity userEntity = repository.findByMail(user.getMail().toLowerCase());
    if (userEntity == null) {
        throw new UsernameNotFoundException("Такого юзера не существует");
    }
    if (!encoder.matches(user.getPassword(), userEntity.getPassword())) {
        throw new UserValidateExeption("Введены некорректные данные");
    }
    return conversionService.convert(userEntity, UserJsonModel.class);
}


    @Override
    public void registration(UserRegistration user) {
        UserEntity userEntity = repository.findByMail(user.getMail().toLowerCase());
        if (userEntity != null) {
            throw new DoubleException("Юзер с таким mail уже существует");
        } else {
            iUserService.create(new UserCreate(user.getMail().toLowerCase(),
                    user.getFio(),
                    user.getPassword()));
            UUID code = UUID.randomUUID();
            userEntity = repository.findByMail(user.getMail().toLowerCase());
            userEntity.setCode(code.toString());
            repository.save(userEntity);
            post(user.getMail().toLowerCase(), "Verification", code.toString());
        }
    }

    @Override
    public void verification(String code, String mail) {
        UserEntity userEntity = repository.findByMail(mail.toLowerCase());
        if (userEntity != null && code.equals(userEntity.getCode())) {
            userEntity.setStatus(new StatusEntity(UserStatus.ACTIVATED.ordinal(),(UserStatus.ACTIVATED)));
            userEntity.setCode(null);
            repository.save(userEntity);
        } else throw new UserNotFoundExeption("Такого юзера не существует");
    }

    private void post(String to, String subject, String text) {
        try {
            JSONObject jo = new JSONObject();
            jo.put("subject", subject);
            jo.put("to", to);
            jo.put("text", text);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .setHeader("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jo.toString())).build();
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (JSONException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
