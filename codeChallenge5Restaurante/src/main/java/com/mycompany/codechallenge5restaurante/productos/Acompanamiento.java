package com.mycompany.codechallenge5restaurante.productos;

public class Acompanamiento implements Producto{
    private String nombre;
    private double precio;

    public Acompanamiento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double obtenerPrecio() {
        return precio;
    }

    public String obtenerNombre() {
        return nombre;
    }
}
