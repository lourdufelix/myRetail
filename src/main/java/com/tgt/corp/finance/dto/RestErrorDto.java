package com.tgt.corp.finance.dto;


import java.util.ArrayList;
import java.util.List;

public class RestErrorDto {

    String message;
    List<ErrorDto> errors;

    public RestErrorDto() {
        errors = new ArrayList<>();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorDto> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDto> errors) {
        this.errors = errors;
    }

    public void addError(String field, String reason)
    {
        errors.add(new ErrorDto(field, reason));
    }
}

class ErrorDto
{
    String field;
    String reason;


    public ErrorDto(String field, String reason) {
        this.field = field;
        this.reason = reason;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
