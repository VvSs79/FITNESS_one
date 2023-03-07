package Mk.JD2_95_22.fitness.servise.user;

import Mk.JD2_95_22.fitness.converter.user.*;
import Mk.JD2_95_22.fitness.core.dto.page.PageDTO;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.core.dto.user.UserDTO;

import Mk.JD2_95_22.fitness.core.dto.user.UserVerification;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import Mk.JD2_95_22.fitness.orm.entity.RoleEntity;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.servise.api.IUserService;
import jakarta.validation.ValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.time.Instant;
import java.util.*;

public class UserService implements IUserService {
    private final IUserRepository repository;

    private final UserConverterDtoToEntity userConverterDtoToEntity;
    private final UserConverterEntityToDTO userConverterEntityToDTO;
    private final UserConverterEntityToModel userConverterEntityToModel;
    private final  UserConverterEntityToPage userConverterEntityToPage;

    public UserService(IUserRepository repository,
                       UserConverterDtoToEntity userConverterDtoToEntity,
                       UserConverterEntityToDTO userConverterEntityToDTO,
                       UserConverterEntityToModel userConverterEntityToModel,
                       UserConverterEntityToPage userConverterEntityToPage) {
        this.repository = repository;
        this.userConverterDtoToEntity = userConverterDtoToEntity;
        this.userConverterEntityToDTO = userConverterEntityToDTO;
        this.userConverterEntityToModel = userConverterEntityToModel;
        this.userConverterEntityToPage = userConverterEntityToPage;
    }

    public void CreatedUser(UserCreated newUser){
        if(newUser==null) {
            throw new NullPointerException("User must not be null");
        }
        UserEntity userEntity=userConverterDtoToEntity.convert(newUser);
        if(userEntity!=null&&userEntity.getStatus().equals(UserStatus.WAITING_ACTIVATION)){
            userEntity.setUuid(UUID.randomUUID());
        }
        repository.save(userEntity);
    }


    public UserEntity getUser(UUID id){
        Optional<UserEntity> findUser=repository.findById(id);
        UserEntity userEntity=findUser.get();
        return userEntity;
    }
    public void UpdateUser(UUID uuid, Instant dt_update, UserCreated userCreated){
        validate(userCreated);
        doubleCheckMail(userCreated);
        UserEntity userEntity=repository.findById(uuid).orElseThrow(()->new ValidationException("Not found user this is a id "+ uuid));
        if ( dt_update.toEpochMilli() == userEntity.getDt_update().toEpochMilli()){
            userEntity.setFio(userCreated.getFIOuser());
            userEntity.setMail(userCreated.getMailUser());
            userEntity.setStatus(userEntity.getStatus());
            userEntity.setPassword(userCreated.getPassword());
            userEntity.setRole(new RoleEntity());
            repository.save(userEntity);
        }  else throw new ValidationException("Version is not correct");
    }
    public void DeleteUserUuid(UUID uuid, List<UserDTO> user){
        Optional<UserEntity> findUser = repository.findById(uuid);
        user.remove(findUser);
    }

    public PageDTO<UserDTO> getALL(Pageable pageable){
        Page<UserEntity> allPage = repository.findAll(pageable);
        List<UserDTO> content = new ArrayList<>();
        for (UserEntity user : allPage) {
            UserDTO userDTO=userConverterEntityToDTO.convert(user);
        }
        return new PageDTO<>(allPage.getNumber(), allPage.getSize(), allPage.getTotalPages(),
                allPage.getTotalElements(), allPage.isFirst(), allPage.getNumberOfElements(),
                allPage.isLast(), content);
    }


    public void verficationUser(UserVerification verificationUser) throws ValidationException {
        if(verificationUser==null){
            throw new ValidationException("There is already a user with this email");
        }

    }

    public void validate( UserCreated user) throws ValidationException {
        String mail= user.getMailUser();
        if(repository.findByMailIgnoreCase(mail)!=null){
            throw new ValidationException("There is already a user with this email");
        }
        if(mail==null){
            throw  new ValidationException("Mail not entered");
        }
        if(!mail.matches("^[a-z0-9][-a-z0-9._]+@([-a-z0-9]+[.])+[a-z]{2,5}$")){
            throw new ValidationException("Wrong format of mail");
        }

        String password= user.getPassword();
        if(password.isBlank()||password==null){
            throw new ValidationException("Password is not entered");
        }
        if(!password.matches("^(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*)$")){
            throw new ValidationException("Is not corrected format of mail");
        }

        String fio= user.getFIOuser();
        if(fio==null || fio.isBlank()){
            throw new ValidationException("FIO not entered");
        }
        if(!fio.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")){
            throw new ValidationException("Is not corrected format of FIO");
        }
        if(fio.length()<7||fio.length()>55){
            throw new ValidationException("length of the name can be from 7 to 55 characters ");
        }
    }
    public void  doubleCheckMail(UserCreated user){
        String mail= user.getMailUser();
        if(repository.findByMailIgnoreCase(mail)!=null||
           repository.findByMailIgnoreCase(mail).equals(mail)){
            throw new ValidationException("User with this mail is a already registered");
        }
    }

}
