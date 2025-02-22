package org.example.Exception;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(String m){
        super(m);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}