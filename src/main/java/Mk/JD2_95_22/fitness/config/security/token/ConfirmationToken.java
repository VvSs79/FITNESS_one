package Mk.JD2_95_22.fitness.config.security.token;

import Mk.JD2_95_22.fitness.core.dto.user.UserRegistration;

import jakarta.persistence.*;

import java.time.Instant;

import java.util.UUID;

@Entity
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant expiresAt;

    private Instant confirmedAt;

    @ManyToOne
    @JoinColumn(nullable = false,
                name = "app_user_id")
    private UserRegistration user;

    public ConfirmationToken() {
    }

    public ConfirmationToken(String token, Instant createdAt, Instant expiresAt, Instant confirmedAt, UserRegistration user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.confirmedAt = confirmedAt;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Instant getConfirmedAt() {
        return confirmedAt;
    }

    public void setConfirmedAt(Instant confirmedAt) {
        this.confirmedAt = confirmedAt;
    }

    public UserRegistration getUser() {
        return user;
    }

    public void setUser(UserRegistration user) {
        this.user = user;
    }
}
