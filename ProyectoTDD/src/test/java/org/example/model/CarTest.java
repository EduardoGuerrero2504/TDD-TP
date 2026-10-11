package org.example.model;

import org.example.excepciones.CarInvalidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @Test
    void instanceCar_datosValidos_success(){

        Car myCar = Car.instance("Marca","Modelo",2020);

        assertEquals("Marca", myCar.getMarca());
        assertEquals("Modelo", myCar.getModelo());
        assertEquals(2020, myCar.getAnio());
    }

    @Test
    void instanceCar_marcaVacio_lanzaExcepcion(){
        assertThrows(CarInvalidaException.class, () -> Car.instance(
                "",
                "Modelo",
                2020
        ));
    }

    @Test
    void instanceCar_modeloVacio_lanzaExcepcion(){
        assertThrows(CarInvalidaException.class, () -> Car.instance(
                "Marca",
                "",
                2020
        ));
    }

    @Test
    void instanceCar_anioVacio_lanzaExcepcion(){
        assertThrows(CarInvalidaException.class, () -> Car.instance(
                "Marca",
                "Modelo",
                1800
        ));
    }

    @Test
    void instanceCar_anioMaximo_lanzaExcepcion() {
        assertThrows(CarInvalidaException.class, () ->
                Car.instance(
                        "Marca",
                        "Modelo",
                        2027
                )
        );
    }
}
