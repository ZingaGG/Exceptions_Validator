package org.example.exception;

import java.io.IOException;

public class WrongInputFormat extends IOException {
    private int errorCode;

    public WrongInputFormat(){};
    public WrongInputFormat(String message){
        super(message);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public WrongInputFormat(int errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
}
