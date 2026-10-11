package org.example.model;
import org.example.excepciones.CuentaBancariaInvalidaException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuentaBancariaTest {

    @Test
    void instanceCuentaBancaria_datosValidos_success(){
        CuentaBancaria myCuenta = CuentaBancaria.instance(
                "Titular",
                new BigDecimal("500000.00"),
                "1234567890123456789012"
        );

        assertEquals("Titular", myCuenta.getTitular());
        assertEquals(new BigDecimal("500000.00"), myCuenta.getSueldo());
        assertEquals("1234567890123456789012", myCuenta.getCbu());
    }

    @Test
    void instanceCuentaBancaria_titularVacio_Excepcion(){
        assertThrows(CuentaBancariaInvalidaException.class, () -> CuentaBancaria.instance(
                "",
                new BigDecimal("500000.00"),
                "1234567890123456789012"
                )
        );
    }

    @Test
    void instanceCuentaBancaria_titularNull_Excepcion() {
        assertThrows(CuentaBancariaInvalidaException.class, () ->
                CuentaBancaria.instance(
                        null,
                        new BigDecimal("500000.00"),
                        "1234567890123456789012"
                )
        );
    }

    @Test
    void instanceCuentaBancaria_sueldoNull_Excepcion() {
        assertThrows(CuentaBancariaInvalidaException.class, () ->
                CuentaBancaria.instance(
                        "Titular",
                        null,
                        "1234567890123456789012"
                )
        );
    }

    @Test
    void instanceCuentaBancaria_sueldoNegativo_Excepcion(){
        assertThrows(CuentaBancariaInvalidaException.class, () ->
                CuentaBancaria.instance(
                        "Titular",
                        new BigDecimal("-100"),
                        "1234567890123456789012"
                )
        );
    }



    @Test
    void instanceCuentaBancaria_cbuInvalido_Excepcion(){
        assertThrows(CuentaBancariaInvalidaException.class, () ->
                CuentaBancaria.instance(
                        "Titular",
                        new BigDecimal("500000.00"),
                        "1234"
                )
        );
    }

    @Test
    void instanceCuentaBancaria_cbuConLetras_Excepcion() {
        assertThrows(CuentaBancariaInvalidaException.class, () ->
                CuentaBancaria.instance(
                        "Titular",
                        new BigDecimal("500000.00"),
                        "12345678901234567890AB"
                )
        );
    }



}
