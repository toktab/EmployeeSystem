package dev.toktab.controller.model;

import lombok.Data;

@Data
public class MessageResponse {
    private boolean succesfullySend;
    private int httpCode;
    private String msg;

    public static MessageResponse ok(String msg){
        var result = new MessageResponse();
        result.setSuccesfullySend(true);
        result.setMsg(msg);
        return result;
    }
    public static MessageResponse fail(String msg){
        var result = new MessageResponse();
        result.setSuccesfullySend(false);
        result.setMsg(msg);
        return result;
    }
}
