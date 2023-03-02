package Mk.JD2_95_22.fitness.core.dto.user;

public class UserVerification {
    private String mail;
    private String link;

    public UserVerification() {
    }

    public UserVerification(String mail, String link) {
        this.mail = mail;
        this.link = link;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
