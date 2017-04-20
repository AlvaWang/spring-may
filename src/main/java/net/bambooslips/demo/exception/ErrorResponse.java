package net.bambooslips.demo.exception;

import java.util.Map;

/**
 * Created by Eureka on 2016/5/13.
 */
public class ErrorResponse {

    public Integer status;
    public String error;
    public String message;
    public String exception;
    public String timeStamp;
    public String trace;

    public ErrorResponse(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.error = (String) errorAttributes.get("exception");
        this.message = (String) errorAttributes.get("message");
        this.timeStamp = errorAttributes.get("timestamp").toString();
        this.trace = (String) errorAttributes.get("trace");
    }

    public ErrorResponse(int status, Exception e) {
        this.status = status;
        this.error = e.getLocalizedMessage();
        this.message = e.getMessage();
        this.trace = e.getStackTrace().toString();
    }

    public ErrorResponse(int status, RuntimeException e) {
        this.status = status;
        this.error = e.getLocalizedMessage();
        this.message = e.getMessage();
        this.trace = e.getStackTrace().toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
