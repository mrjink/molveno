package com.molvenolakeresort.models.restaurant.httpResponseModel;

public abstract class Response {

    public String message = "";

    public Response(String message) {
        this.message = message;
    }

//    public String getMessage()
//    {
//        return message;
//    }
}
