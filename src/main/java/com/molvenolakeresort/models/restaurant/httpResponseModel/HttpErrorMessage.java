package com.molvenolakeresort.models.restaurant.httpResponseModel;

public class HttpErrorMessage
{
    String error;

    public HttpErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
