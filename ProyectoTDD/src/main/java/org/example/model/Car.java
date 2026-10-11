package org.example.model;

import org.example.excepciones.CarInvalidaException;

public class Car {

    private String marca;
    private String modelo;
    private int anio;

    private Car (String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public static Car instance(String marca, String modelo, int anio) {

        if (marca == null || marca.trim().isEmpty()) {
            throw new CarInvalidaException("Marca es null");
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new CarInvalidaException("Modelo es null");
        }
        if (anio < 1886 || anio > 2026) {
            throw new CarInvalidaException("E año debe estar entre 1886 y 2026");
        }




        return new Car(marca, modelo, anio);
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public int getAnio() {
        return anio;
    }
}
