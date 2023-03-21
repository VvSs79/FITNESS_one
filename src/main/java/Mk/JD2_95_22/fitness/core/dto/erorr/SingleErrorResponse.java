package Mk.JD2_95_22.fitness.core.dto.erorr;

public class SingleErrorResponse extends Throwable{
    private String logref;
    private String massage;

    public SingleErrorResponse(String logref, String massage) {
        this.logref = logref;
        this.massage = massage;
    }

    public String getLogref() {
        return logref;
    }

    public String getMassage() {
        return massage;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
