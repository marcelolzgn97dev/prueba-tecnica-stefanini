package com.example.prueba_tecnica_stefanini.infrastructure.exception;


public class PetCreationException extends RuntimeException{
    public PetCreationException(String message){
        super(message);
    }
}
