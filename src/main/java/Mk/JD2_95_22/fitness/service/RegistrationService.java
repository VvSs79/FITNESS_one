package Mk.JD2_95_22.fitness.service;


import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.mail.MailDTO;
import Mk.JD2_95_22.fitness.core.dto.user.*;
import Mk.JD2_95_22.fitness.core.exception.user.UserValidateExeption;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import Mk.JD2_95_22.fitness.service.api.mail.IMailService;
import Mk.JD2_95_22.fitness.service.api.user.IRegistrationService;
import Mk.JD2_95_22.fitness.service.api.user.IUserService;
import Mk.JD2_95_22.fitness.core.exception.check_exeptions.DoubleException;
import Mk.JD2_95_22.fitness.orm.repository.user.IRegistrationUserRepository;
import Mk.JD2_95_22.fitness.core.dto.user_utils.UserStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;


@Transactional(readOnly = true)
public class RegistrationService implements IRegistrationService {

    private final IRegistrationUserRepository repository;
    private final ConversionService conversionService;
    private final IMailService emailService;
    private final IUserService iUserService;
    private final PasswordEncoder encoder;

    public RegistrationService(IRegistrationUserRepository repository,
                               ConversionService conversionService,
                               IMailService emailService,
                               IUserService iUserService,
                               PasswordEncoder encoder) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.emailService = emailService;
        this.iUserService = iUserService;
        this.encoder = encoder;

    }

    @Transactional
    @Override
    public void create(@Validated UserRegistration user) {
        if (repository.findByMailIgnoreCase(user.getMail()).isPresent()) {
            throw new DoubleException("User with this is a mail is exist");
        } else {
            iUserService.create(new UserCreate(user.getMail(),
                    user.getFio(),
                    user.getPassword()));
            String subject="Activate your account";
            UserEntity userEntity = repository.findByMail(user.getMail());
            String code = UUID.randomUUID().toString();
            String mail = user.getMail();
            userEntity.setMail(mail);
            userEntity.setCode(code);
            repository.save(userEntity);
            String message="Hi, " + userEntity.getFio() + " press to link and pass verification: http://localhost:8080/api/v1/users/verification?code=" +
                    "\n" + code + " &mail =" + userEntity.getMail() +
                    "\n If you have not registered an account - ignore this is message";
            emailService.sendVerificationMessage(userEntity.getMail(),subject,message);
        }
    }

    public UserJsonModel logIn(@Validated UserLogin user) {
    UserEntity userEntity = repository.findByMail(user.getMail());
    if (!encoder.matches(user.getPassword(), userEntity.getPassword())) {
        throw new UserValidateExeption("Incorrect password and mail");
}щ
    return conversionService.convert(userEntity, UserJsonModel.class);
}

    @Override
    public void verification(String code, String mail) {
        UserEntity userEntity = repository.findByMail(mail);
        if (userEntity != null && code.equals(userEntity.getCode())) {
            userEntity.setStatus(new StatusEntity(UserStatus.ACTIVATED.ordinal(),(UserStatus.ACTIVATED)));
            userEntity.setCode(null);
            repository.save(userEntity);
        } else throw new UserValidateExeption("Incorrect mail and code");
    }

//    private UserEntity find(String mail){
//        UserEntity userEntity = repository.findByMail(mail.toLowerCase());
//        if(userEntity==null){
//            throw new UsernameNotFoundException("User with this mail is not registered");
//        }
//        return repository.findByMail(mail);
//    }

    @Override
    public UserJsonModel getUser(String mail) {
        UserEntity userEntity = repository.findByMail(mail);
        if (!conversionService.canConvert(UserEntity.class, UserJsonModel.class)) {
            throw new IllegalStateException("Can not convert UserEntity.class to UserModel.class");
        }
        return conversionService.convert(userEntity, UserJsonModel.class);
    }
    private void sendMessage(String to, String code ){
        try {
            JSONObject object =new JSONObject();
            object.put("to", to);
            object.put("subject", "Активируйте свою учетную запись в Thyme ");
            object.put("text",code);
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/v1/users/verification?code="))
                    .setHeader("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(object.toString())).build();
            httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .exceptionally(e -> "Exception: "+ e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }}

