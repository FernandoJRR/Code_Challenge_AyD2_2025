package com.mycompany.codechallenge5restaurante.productos;

public class PlatoPrincipal implements Producto {
    double precio;
    String nombre;

    public PlatoPrincipal(String nombre, double precio) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public double obtenerPrecio() {
        return this.precio;
    }

    public String obtenerNombre() {
        return this.nombre;
    }
}
