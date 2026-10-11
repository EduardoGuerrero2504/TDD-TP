package org.example.model;

import org.example.excepciones.CarInvalidaException;
import org.example.excepciones.StudentInvalidaException;

public class Student {

    private String nombreApellido;
    private String dni;
    private int edad;

    private Student(String nombreApellido, String dni, int edad) {
        this.nombreApellido = nombreApellido;
        this.dni = dni;
        this.edad = edad;
    }

    public static Student instance(String nombreApellido, String dni, int edad) {

        if (nombreApellido == null || nombreApellido.trim().isEmpty()){
            throw new StudentInvalidaException("Nombre es null");
        }

        if (dni == null || dni.trim().isEmpty() || !dni.matches("[0-9]{7,8}") || dni.equals("00000000")){
            throw new StudentInvalidaException("El DNI no puede estar vacio, debe contener al menos 7 digitos y no puede ser 0 ");
        }

        if (edad < 18 || edad > 100){
            throw new StudentInvalidaException("El estudiante debe ser mayor de edad");
        }



        return new Student(nombreApellido, dni, edad);
    }


    public String getNombreApellido() {
        return nombreApellido;
    }
    public String getDni() {
        return dni;
    }
    public int getEdad() {
        return edad;
    }
}
