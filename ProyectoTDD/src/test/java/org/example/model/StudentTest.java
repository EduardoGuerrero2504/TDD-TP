package org.example.model;

import org.example.excepciones.StudentInvalidaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentTest {

    @Test
    void instanceStudent_datosValidos_success(){
        Student myStudent = Student.instance(
                "nombreApellido",
                "45589378",
                22
        );
    }

    @Test
    void instanceStudent_nombreVacio_lanzaExcepcion(){
        assertThrows(StudentInvalidaException.class, () -> Student.instance(
                "",
                "45589378",
                22
        ));
    }
    @Test
    void instanceStudent_dniVacio_lanzaExcepcion(){
        assertThrows(StudentInvalidaException.class, () -> Student.instance(
                "nombreApellido",
                "",
                22
        ));
    }

    @Test
    void instanceStudent_dniConLetras_lanzaExcepcion() {
        assertThrows(StudentInvalidaException.class, () ->
                Student.instance(
                        "nombreApellido",
                        "ABC12345",
                        22
                )
        );
    }


    @Test
    void instanceStudent_edadInvalido_lanzaExcepcion(){
        assertThrows(StudentInvalidaException.class, () -> Student.instance(
                "nombreApellido",
                "45589378",
                5
        ));

    }
}
