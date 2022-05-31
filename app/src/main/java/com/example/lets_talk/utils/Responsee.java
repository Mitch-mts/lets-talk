package com.example.lets_talk.utils;

import java.io.Serializable;

/**
 * Created by Mitch on 30/7/2019.
 */
public class Responsee<T> implements Serializable {
    private int statusCode;
    private boolean success;
    private String message;
    private T result;

    public Responsee() {
    }

    public Responsee<T> buildSuccessResponse(String Message){
        this.statusCode = Constants.SUCCESS_INT_VALUE;
        this.success = true;
        this.message = message;
        this.result = null;
        return  this;
    }

    public Responsee<T> buildSuccessResponse(String Message, final T  result){
        this.statusCode = Constants.SUCCESS_INT_VALUE;
        this.success = true;
        this.message = message;
        this.result = null;
        return  this;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Responsee{" +
                "statusCode=" + statusCode +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
