package com.chalenge.moby.exceptions;

public class TechnologyAlreadyExistsException extends RuntimeException{

    public TechnologyAlreadyExistsException(String message){
        super(message);
    }
}
