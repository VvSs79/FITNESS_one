package Mk.JD2_95_22.fitness.core.exception.mail;

import Mk.JD2_95_22.fitness.core.dto.erorr.ErrorDTO;

public class ConversionTimeException extends RuntimeException{
    private String logref;

    public ConversionTimeException(){

    };

    public ConversionTimeException(String message,String logref) {
        super(message);
        this.logref = logref;
    }

    public String getErrorDTO(){
        return logref;
    }

    public void setErrorDTO(String errorDTO) {
        this.logref = errorDTO;
    }
}
