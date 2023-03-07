package Mk.JD2_95_22.fitness.servise.user;

import Mk.JD2_95_22.fitness.config.security.token.ConfirmationToken;
import Mk.JD2_95_22.fitness.core.dto.user.UserCreated;
import Mk.JD2_95_22.fitness.orm.entity.UserEntity;
import Mk.JD2_95_22.fitness.orm.repository.IUserRepository;
import Mk.JD2_95_22.fitness.servise.token.ConfirmationTokenService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.swing.text.html.parser.Entity;
import java.time.Instant;
import java.util.UUID;

public class AppUserService implements UserDetailsService {
    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public AppUserService(IUserRepository repository, PasswordEncoder passwordEncoder, ConfirmationTokenService confirmationTokenService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        if(repository.findByMailIgnoreCase(email).getMail().isEmpty()||repository.findByMailIgnoreCase(email)==null)
        throw new UsernameNotFoundException(String.format("User with email %s not found", email));
        return loadUserByUsername(email);
    }


    public String signUpUser(UserEntity userCreated, String email){
        boolean userExist=repository.findByMailIgnoreCase(userCreated.getMail());
        String appUserPrevious =  userCreated.getMail().;
        UserDetails userExists=loadUserByUsername(email);

       if(!loadUserByUsername(email).getUsername().isBlank()) {

                String token = UUID.randomUUID().toString();
           saveConfirmationToken(userCreated.getMail(),token).

                //A method to save user and token in this class
                saveConfirmationToken(appUserPrevious, token);

                return token;

            }
            throw new IllegalStateException(String.format("User with email %s already exists!", userCreated.getMailUser()));
        }

        String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);

        //Saving the user after encoding the password
        appUserRepository.save(appUser);

        //Creating a token from UUID
        String token = UUID.randomUUID().toString();

        //Getting the confirmation token and then saving it
        saveConfirmationToken(appUser, token);


        //Returning token
        return token;
    }


    private void saveConfirmationToken(Entity appUser, String token) {
        ConfirmationToken confirmationToken = new ConfirmationToken(token, Instant.now(),
                Instant.now().plusSeconds(6000), appUser);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);

    }

}
