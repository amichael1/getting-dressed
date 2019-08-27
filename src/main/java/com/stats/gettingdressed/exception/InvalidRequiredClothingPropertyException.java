package com.stats.gettingdressed.exception;

/*
 * Exception to be thrown when properties file can not be read
 **/
public class InvalidRequiredClothingPropertyException extends Exception {
    public InvalidRequiredClothingPropertyException(){
        super();
    }

    public InvalidRequiredClothingPropertyException(String message){
        super(message);
    }

    public InvalidRequiredClothingPropertyException(String message, Throwable cause){
        super(message,cause);
    }
}
