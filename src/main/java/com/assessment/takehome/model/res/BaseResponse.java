package com.assessment.takehome.model.res;

public class BaseResponse {
    private String message;
    private Boolean status;

    public BaseResponse() {
    }

    public BaseResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
