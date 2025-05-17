package com.DevTino.festino_admin.exception;

public class ServiceException extends RuntimeException{

    ExceptionEnum exceptionEnum;

    public ServiceException(ExceptionEnum e){

        super(e.getMessage());
        this.exceptionEnum = e;

    }


}
