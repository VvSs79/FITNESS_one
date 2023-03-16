package Mk.JD2_95_22.fitness.servise.user;

import Mk.JD2_95_22.fitness.core.dto.model.UserModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;
import Mk.JD2_95_22.fitness.core.exeption.SingleErrorResponse;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import Mk.JD2_95_22.fitness.orm.entity.utils.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.utils.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.user.UserEntity;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.servise.api.user.IUserService;
import Mk.JD2_95_22.fitness.servise.my_exeption.page.PageNotFoundExeption;
import Mk.JD2_95_22.fitness.servise.my_exeption.user.UserNotFoundExeption;
import Mk.JD2_95_22.fitness.servise.my_exeption.version.InvalidVersionExeption;
import Mk.JD2_95_22.fitness.servise.validation.api.IValidator;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import java.time.Instant;
import java.util.*;


public class UserService implements IUserService {
    private final IUserRepository repository;
    private final IValidator<UserCreated> validator;
    private final ConversionService conversionService;
    private final PasswordEncoder encoder;

    public UserService(IUserRepository repository, IValidator<UserCreated> validator, ConversionService conversionService, PasswordEncoder encoder) {
        this.repository = repository;
        this.validator = validator;
        this.conversionService = conversionService;
        this.encoder = encoder;
    }
    @Override
    public void CreatedUser(@Validated UserCreated newUser){
        if(newUser==null){
            throw new SingleErrorResponse("Parameters not entered");
        }
        if(repository.existsByUuidOrMail(newUser.getUuid(), newUser.getMailUser())){
            throw new SingleErrorResponse("User with this email/id already exists.");
        }
        validator.validate(newUser);
        String encode = encoder.encode(newUser.getPassword());
        newUser.setPassword(encode);
        if (!conversionService.canConvert(UserCreated.class, UserEntity.class)) {
            throw new SingleErrorResponse("Can't convert UserCreated.class to UserEntity.class");
        }
        UserEntity userEntity = conversionService.convert(newUser, UserEntity.class);
        userEntity.setUuid(UUID.randomUUID());
        Instant dtCreated = Instant.now();
        Instant dtUpdated = dtCreated;
        userEntity.setDtCreate(dtCreated);
        userEntity.setDtUpdate(dtUpdated);
        repository.save(userEntity);
    }
    @Override
    public UserDTO getUser(UUID id, String mail){
        UserEntity userEntityId = repository.findById(id)
                .orElseThrow(() -> new UserNotFoundExeption("There is no user with such id"));
        UserEntity userEntityMail = repository.findByMail(mail);
        if(userEntityId==null||userEntityMail==null){
            throw new SingleErrorResponse("This user does not exist");
        }
        if (!conversionService.canConvert(UserEntity.class, UserModel.class)) {
            throw new IllegalStateException("Can not convert UserEntity.class to UserModel.class");
        }
        return conversionService.convert(userEntityId, UserDTO.class);
    }



    public UserDTO getUsers(String mail){
        UserEntity userEntityMail= repository.findByMail(mail);
        if(userEntityMail==null){
            new SingleErrorResponse("There is no user with such id");
    }
        if (!conversionService.canConvert(UserEntity.class, UserModel.class)) {
        throw new IllegalStateException("Can not convert UserEntity.class to UserModel.class");
    }
        return conversionService.convert(userEntityMail, UserDTO.class);
    }

    @Override
    public void UpdateUser(UUID uuid, Instant dt_update, UserCreated userCreated){

        UserEntity userEntity=repository.findById(uuid).orElseThrow(()->new PageNotFoundExeption("Not found user this is a id "+ uuid));
        if ( dt_update.toEpochMilli() == userEntity.getDtUpdate().toEpochMilli()){
            userEntity.setFio(userCreated.getFIOuser());
            userEntity.setMail(userCreated.getMailUser());
            userEntity.setStatus(userEntity.getStatus());
            userEntity.setPassword(userCreated.getPassword());
            userEntity.setRole(new RoleEntity());
            repository.save(userEntity);
        }  else throw new InvalidVersionExeption("Version is not correct");
    }
    @Override
    public void DeactivatedUserUuid(UUID uuid, String mail){
        getUser(uuid,mail);
        UserEntity foundUser=conversionService.convert(getUser(uuid, mail), UserEntity.class);
        if(foundUser==null){
            throw new UserNotFoundExeption("Not found user this is a id and mail");
        }
        foundUser.setStatus(new StatusEntity(UserStatus.DEACTIVATED));
    }
    @Override
    public PageDTO<UserDTO> getPageUsers(int page, int size){
        PageRequest paging=PageRequest.of(page, size);
        Page<UserEntity> all=repository.findAll(paging);
        List<UserDTO> pageOfUsers=all.getContent().stream()
                .map(s->conversionService.convert(s,UserDTO.class))
                .toList();
//        List<UserDTO> pageOfUsers = new ArrayList<>();
//        for (UserEntity userEntity : all.getContent()) {
//            UserDTO convert = conversionService.convert(userEntity, UserDTO.class);
//            pageOfUsers.add(convert);
//        }
        return new PageDTO<>(page,
                size,
                all.getTotalPages(),
                all.getTotalElements(),
                all.isFirst(),
                all.getNumberOfElements(),
                all.isLast(),
                pageOfUsers);
    }
    public UserDetails loadUserByUsername(String username) throws UserNotFoundExeption{
        UserEntity myUser = repository.findByMail(username);
        if(myUser ==null){
            new UserNotFoundExeption("Unknown user: ");
        }
        return conversionService.convert(myUser,UserModel.class);
    }
}
