package Mk.JD2_95_22.fitness.core.dto.token;

import Mk.JD2_95_22.fitness.core.dto.user.User;

import java.time.Instant;

public class Token {
    private  long tokenid;
    private String confirmationToken;
    private Instant createdDate;
    private User user;

    public Token(long tokenid, String confirmationToken, Instant createdDate, User user) {
        this.tokenid = tokenid;
        this.confirmationToken = confirmationToken;
        this.createdDate = createdDate;
        this.user = user;
    }

    public long getTokenid() {
        return tokenid;
    }

    public void setTokenid(long tokenid) {
        this.tokenid = tokenid;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
