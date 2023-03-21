package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreate;
import Mk.JD2_95_22.fitness.core.dto.user.UserUpdate;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.user.UserNotFoundExeption;
import Mk.JD2_95_22.fitness.core.exception.validation.UserCreatedValidator;
import Mk.JD2_95_22.fitness.orm.entity.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import Mk.JD2_95_22.fitness.service.api.user.IUserService;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.check_exeptions.DoubleException;
import Mk.JD2_95_22.fitness.core.exception.my_exeption.check_exeptions.VersionException;
import Mk.JD2_95_22.fitness.orm.repository.user.IUserRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserService implements IUserService {

    private final IUserRepository repository;
    private final ConversionService conversionService;
    private final PasswordEncoder encoder;
    private final UserCreatedValidator validator;

    public UserService(IUserRepository repository, ConversionService conversionService, PasswordEncoder encoder, UserCreatedValidator validator) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.encoder = encoder;
        this.validator = validator;
    }

    @Override
    public void create(UserCreate user) {
        UserEntity userEntity = repository.findByMail(user.getMail());
        if (userEntity != null) {
            throw new DoubleException("User this is a mail is exist");
        } else {
            validator.validate(user);
            String encode = encoder.encode(user.getPassword());
            user.setPassword(encode);
            repository.save(conversionService.convert(user, UserEntity.class));
        }
    }

    @Override
    public PageDTO<UserJsonModel> get(int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        Page<UserEntity> all = repository.findAll(paging);
        List<UserJsonModel> usersPages = new ArrayList<>();
        for (UserEntity userEntity : all.getContent()) {
            UserJsonModel convert = conversionService.convert(userEntity, UserJsonModel.class);
            usersPages.add(convert);
        }
        return new PageDTO<>(page,
                size,
                all.getTotalPages(),
                all.getTotalElements(),
                all.isFirst(),
                all.getNumberOfElements(),
                all.isLast(),
                usersPages);
    }

    @Override
    public UserJsonModel get(UUID uuid) {
        UserEntity userEntity = this.repository.findById(uuid).orElseThrow(() ->
                new UserNotFoundExeption("This user does not exist"));
        return conversionService.convert(userEntity, UserJsonModel.class);
    }

    @Override
    public void update(UserUpdate userUpdate) {
        UserEntity userEntity = repository.findById(userUpdate.getUuid()).orElseThrow(() -> new UserNotFoundExeption("This user does not exist"));
        if (userEntity.getDtUpdate().toEpochMilli() == userUpdate.getDtUpdate().toEpochMilli()) {
            userEntity.setMail(userUpdate.getUserDTO().getMail());
            userEntity.setFio(userUpdate.getUserDTO().getFio());
            userEntity.setPassword(userUpdate.getUserDTO().getPassword());
            userEntity.setRole(new RoleEntity(userUpdate.getUserDTO().getRole()));
            userEntity.setStatus(new StatusEntity(userUpdate.getUserDTO().getStatus()));
            repository.save(userEntity);
        } else throw new VersionException("This is version does not exist");
    }

    @Override
    public UserJsonModel getUser(String mail) {
        UserEntity userEntity = this.repository.findByMail(mail);
        if (userEntity == null) {
            throw new UserNotFoundExeption("This user does not exist");
        }
        return conversionService.convert(userEntity, UserJsonModel.class);
    }
}
