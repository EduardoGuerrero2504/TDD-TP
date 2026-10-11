package org.example.model;

import org.example.excepciones.CuentaBancariaInvalidaException;

import java.math.BigDecimal;

public class CuentaBancaria {

    private String titular;
    private BigDecimal sueldo;
    private String cbu;

    private CuentaBancaria (String titular, BigDecimal sueldo, String cbu) {
        this.titular = titular;
        this.sueldo = sueldo;
        this.cbu = cbu;
    }

    public static CuentaBancaria instance(String titular, BigDecimal sueldo, String cbu) {

        if (titular == null || titular.trim().isEmpty()) {
            throw new CuentaBancariaInvalidaException("El titular no puede ser null");
        }

        if (sueldo == null || sueldo.compareTo(BigDecimal.ZERO) <= 0) {
            throw new CuentaBancariaInvalidaException("El sueldo no pude ser null y negativo");
        }

        if (cbu == null || !cbu.matches("[0-9]{22}")) {
            throw new CuentaBancariaInvalidaException("El cbu debe contener 22 caracteres");
        }

        return new CuentaBancaria(titular, sueldo, cbu);
    }
    public String getTitular() {
        return titular;
    }
    public BigDecimal getSueldo() {
        return sueldo;
    }
    public String getCbu() {
        return cbu;
    }


}
