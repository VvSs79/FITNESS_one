package Mk.JD2_95_22.fitness.service;

import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreate;
import Mk.JD2_95_22.fitness.core.dto.user.UserUpdate;
import Mk.JD2_95_22.fitness.core.exception.converter.ConverterExeption;
import Mk.JD2_95_22.fitness.orm.entity.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.StatusEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import Mk.JD2_95_22.fitness.service.api.user.IUserService;
import Mk.JD2_95_22.fitness.core.exception.check_exeptions.DoubleException;
import Mk.JD2_95_22.fitness.core.exception.check_exeptions.VersionException;
import Mk.JD2_95_22.fitness.orm.repository.user.IUserRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
public class UserService implements IUserService {

    private final IUserRepository repository;
    private final ConversionService conversionService;
    private final PasswordEncoder encoder;

    public UserService(IUserRepository repository, ConversionService conversionService, PasswordEncoder encoder) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.encoder = encoder;
    }

    @Override
@Transactional
public void create(@Validated UserCreate user) {
    if (repository.findByMailIgnoreCase(user.getMail()).isPresent()) {
        throw new DoubleException("User with this is a mail is exist");
    } else {

        String encode = encoder.encode(user.getPassword());
        user.setPassword(encode);
        if (!conversionService.canConvert(UserJsonModel.class, UserEntity.class)) {
            throw new ConverterExeption("Can not convert UserJsonModel.class to UserEntity.class");
        }
        UserEntity userEntity = conversionService.convert(user, UserEntity.class);
        UUID uuid = UUID.randomUUID();
        userEntity.setUuid(uuid);
        Instant dtCreated = Instant.now();
        userEntity.setDtCreate(dtCreated);
        userEntity.setDtUpdate(dtCreated);
        repository.save(userEntity);

    }
    }

    @Override
    public PageDTO<UserJsonModel> getPageUsers(int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        Page<UserEntity> all = repository.findAll(paging);

        if (!conversionService.canConvert(UserEntity.class, UserJsonModel.class)) {
            throw new ConverterExeption("Can not convert UserEntity.class to UserModel.class");
        }

        List<UserJsonModel> usersPages = all.getContent().stream()
                .map(s -> conversionService.convert(s, UserJsonModel.class))
                .collect(Collectors.toList());
        return new PageDTO<UserJsonModel>(page,
                size,
                all.getTotalPages(),
                all.getTotalElements(),
                all.isFirst(),
                all.getNumberOfElements(),
                all.isLast(),
                usersPages);
    }


    @Override
    public UserJsonModel getUserUuid(UUID uuid) {
        UserEntity userEntity = this.repository.findById(uuid).orElseThrow(() -> new UsernameNotFoundException("This user does not exist"));
        if (!conversionService.canConvert(UserEntity.class, UserJsonModel.class)) {
            throw new ConverterExeption("Can not convert UserEntity.class to UserJsonModel.class");
        }
        return conversionService.convert(userEntity, UserJsonModel.class);
    }

    @Override
    @Transactional
    public UserJsonModel update(@Validated UserUpdate updateUserDto) {
        UserEntity userEntity = repository.findById(updateUserDto.getUuid()).orElseThrow(() -> new UsernameNotFoundException("There is no user with such mail"));
        if (userEntity.getDtUpdate().toEpochMilli() == updateUserDto.getDtUpdate().toEpochMilli()) {
            userEntity.setMail(updateUserDto.getUserDTO().getMail().toLowerCase());
            userEntity.setFio(updateUserDto.getUserDTO().getFio());
            userEntity.setPassword(updateUserDto.getUserDTO().getPassword());
            userEntity.setRole(new RoleEntity(updateUserDto.getUserDTO().getRole().ordinal(),updateUserDto.getUserDTO().getRole()));
            userEntity.setStatus(new StatusEntity(updateUserDto.getUserDTO().getStatus().ordinal(),updateUserDto.getUserDTO().getStatus()));
            repository.save(userEntity);
        } else throw new VersionException("This is version does not exist");
        return conversionService.convert(userEntity, UserJsonModel.class);
    }

    @Override
    public UserJsonModel getUser(String mail) {
        UserEntity userEntity = this.repository.findByMail(mail.toLowerCase());
        if (userEntity == null) {
            throw new UsernameNotFoundException("There is no user with such mail");
        }

        if (!conversionService.canConvert(UserEntity.class, UserJsonModel.class)) {
            throw new ConverterExeption("Can not convert UserEntity.class to UserJsonModel.class");
        }

        return conversionService.convert(userEntity, UserJsonModel.class);
    }
}
