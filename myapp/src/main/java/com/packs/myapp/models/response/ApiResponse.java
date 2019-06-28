package com.packs.myapp.models.response;

import com.packs.myapp.models.entity.Users;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Optional;


@Getter
@Setter
@ToString
public class ApiResponse<T> {
    private HttpStatus httpStatus = HttpStatus.OK;
    private String message = "success";
    private T data;
    private int code = 200;

    public ApiResponse(int code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ApiResponse(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(Optional<Users> user) {
        this.data= (T) user;
    }

    //Static constructor methods
    public static <T> ApiResponse make(int code,HttpStatus httpStatus, String message) {
        return new ApiResponse(code,httpStatus, message);
    }

    public static <T> ApiResponse make(int code,String message) {
        return new ApiResponse(code,message);
    }

    public static ApiResponse make(Optional<Users> user){
        return new ApiResponse(user);
    }


}
