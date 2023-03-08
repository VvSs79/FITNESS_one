package Mk.JD2_95_22.fitness.core.dto.user;

import Mk.JD2_95_22.fitness.core.util.UserRole;
import Mk.JD2_95_22.fitness.core.util.UserStatus;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


public class UserCreated {
    private UUID uuid;
    private Instant dtCreate;
    private Instant dtUpdate;
    private String FIOuser;
    private String mailUser;
    private String password;
    private UserRole userRole;
    private UserStatus userStatus;

    public UserCreated(UUID uuid, Instant dtCreate, Instant dtUpdate, String FIOuser, String mailUser, String password, UserRole userRole, UserStatus userStatus) {
        this.uuid = uuid;
        this.dtCreate = dtCreate;
        this.dtUpdate = dtUpdate;
        this.FIOuser = FIOuser;
        this.mailUser = mailUser;
        this.password = password;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Instant getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(Instant dtCreate) {
        this.dtCreate = dtCreate;
    }

    public Instant getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(Instant dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public String getFIOuser() {
        return FIOuser;
    }

    public void setFIOuser(String FIOuser) {
        this.FIOuser = FIOuser;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreated that = (UserCreated) o;
        return Objects.equals(uuid, that.uuid) && Objects.equals(dtCreate, that.dtCreate) && Objects.equals(dtUpdate, that.dtUpdate) && Objects.equals(FIOuser, that.FIOuser) && Objects.equals(mailUser, that.mailUser) && Objects.equals(password, that.password) && userRole == that.userRole && userStatus == that.userStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, dtCreate, dtUpdate, FIOuser, mailUser, password, userRole, userStatus);
    }
}
