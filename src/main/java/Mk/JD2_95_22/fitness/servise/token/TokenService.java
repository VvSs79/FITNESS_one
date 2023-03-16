package Mk.JD2_95_22.fitness.servise.token;

import Mk.JD2_95_22.fitness.config.security.token.ConfirmationToken;
import Mk.JD2_95_22.fitness.orm.repository.IConfirmationTokenRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.Optional;

@Service
public class TokenService {

    private final IConfirmationTokenRepository confirmationTokenRepository;

    public TokenService(IConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return Math.toIntExact(confirmationTokenRepository.updateConfirmedAt(token, Instant.now()));
    }
}
