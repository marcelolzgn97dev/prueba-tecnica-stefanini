package com.example.prueba_tecnica_stefanini.infrastructure.exception;

public class PetNotFoundException extends RuntimeException{
    public PetNotFoundException(String message){
        super(message);
    }
}
