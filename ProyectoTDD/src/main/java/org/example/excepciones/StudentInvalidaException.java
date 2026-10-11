package org.example.excepciones;

public class StudentInvalidaException extends RuntimeException{
    public StudentInvalidaException(String mensaje){
        super(mensaje);
    }
}
