package Mk.JD2_95_22.fitness.core.dto.user;

import Mk.JD2_95_22.fitness.core.dto.BasicEssence.Essence;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import core.util.UserRole;
import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable {
    private Essence essence;
    private String mail;
    private String fio;
    private UserRole role;
    private UserStatus status;

    public User(Essence essence, String mail, String fio, UserRole role, UserStatus status) {
        this.essence = essence;
        this.mail = mail;
        this.fio = fio;
        this.role = role;
        this.status = status;
    }

    public Essence getEssence() {
        return essence;
    }

    public void setEssence(Essence essence) {
        this.essence = essence;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(essence, user.essence) && Objects.equals(mail, user.mail) && Objects.equals(fio, user.fio) && role == user.role && status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(essence, mail, fio, role, status);
    }

    @Override
    public String toString() {
        return "User{" +
                "essence=" + essence +
                ", mail='" + mail + '\'' +
                ", fio='" + fio + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
