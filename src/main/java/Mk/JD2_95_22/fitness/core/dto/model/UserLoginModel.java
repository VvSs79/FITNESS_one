package Mk.JD2_95_22.fitness.core.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoginModel {
    @JsonProperty("mailUser")
    private String mailUser;
    @JsonProperty("password")
    private String password;

    public UserLoginModel() {
    }

    public UserLoginModel(String mailUser, String password) {
        this.mailUser = mailUser;
        this.password = password;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
