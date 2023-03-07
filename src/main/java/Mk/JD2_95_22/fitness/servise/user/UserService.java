package Mk.JD2_95_22.fitness.servise.user;

import Mk.JD2_95_22.fitness.converter.user.*;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;

public class UserService {
    private final IUserRepository repository;

    private final UserConverterDtoToEntity userConverterDtoToEntity;
    private final UserConverterEntityToDTO userConverterEntityToDTO;
    private final UserConverterEntityToModel userConverterEntityToModel;
    private final  UserConverterEntityToPage userConverterEntityToPage;

    public UserService(IUserRepository repository, UserConverterDtoToEntity userConverterDtoToEntity, UserConverterEntityToDTO userConverterEntityToDTO, UserConverterEntityToModel userConverterEntityToModel, UserConverterEntityToPage userConverterEntityToPage) {
        this.repository = repository;
        this.userConverterDtoToEntity = userConverterDtoToEntity;
        this.userConverterEntityToDTO = userConverterEntityToDTO;
        this.userConverterEntityToModel = userConverterEntityToModel;
        this.userConverterEntityToPage = userConverterEntityToPage;
    }

    public void CreatedUser(UserDTO newUser){
        if(newUser==null) {
            throw new NullPointerException("User must not be null");
        }
        UserEntity userEntity=converterUserToUserEntity.convert(newUser);
        repository.save(userEntity);

    }


    public UserEntity getUser(UUID id){
        Optional<UserEntity> findUser=repository.findById(id);
        UserEntity userEntity=findUser.get();
        return userEntity;

    }
    public void UpdateUser(){};
    public void DeleteUser(){};
    public void exist(){};
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

}
