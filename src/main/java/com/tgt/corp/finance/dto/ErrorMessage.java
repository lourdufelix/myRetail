package com.tgt.corp.finance.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorMessage {

    private String status;

    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.SSS");
    Date dt = new Date();
    private String timestamp=sdf.format(dt);

    private String message;


    //Getters and Setters

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
