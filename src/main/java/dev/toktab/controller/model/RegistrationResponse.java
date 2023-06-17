package dev.toktab.controller.model;

import lombok.Data;

@Data
public class RegistrationResponse {

    private boolean isSuccessful;
    private int httpCode;
    private String msg;

    public static RegistrationResponse ok(String msg) {
        var result = new RegistrationResponse();
        result.setSuccessful(true);
        result.setMsg(msg);
        return result;
    }
    public static RegistrationResponse fail(String msg) {
        var result = new RegistrationResponse();
        result.setSuccessful(false);
        result.setMsg(msg);
        return result;
    }
}
