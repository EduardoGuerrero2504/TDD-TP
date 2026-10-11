package org.example.excepciones;

public class CarInvalidaException extends RuntimeException{
    public CarInvalidaException(String mensaje){
        super(mensaje);
    }
}
