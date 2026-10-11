package org.example.excepciones;

public class CuentaBancariaInvalidaException extends RuntimeException{
    public CuentaBancariaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
