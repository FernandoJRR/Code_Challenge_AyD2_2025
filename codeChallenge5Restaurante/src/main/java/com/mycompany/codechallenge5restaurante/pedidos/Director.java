package com.mycompany.codechallenge5restaurante.pedidos;

import com.mycompany.codechallenge5restaurante.productos.Acompanamiento;
import com.mycompany.codechallenge5restaurante.productos.Bebida;
import com.mycompany.codechallenge5restaurante.productos.Extra;
import com.mycompany.codechallenge5restaurante.productos.PlatoPrincipal;

public class Director {
    public void makeMenuInfantil(PedidoBuilder builder) {
        builder.reset();
        builder.setPlatoPrincipal(new PlatoPrincipal("Hamburguesa", 50));
        builder.setAcompanamiento(new Acompanamiento("Papas", 20));
        builder.setBebida(new Bebida("Jugo", 15));
        builder.setExtra(new Extra("Juguete", 10));
    }

    public void makeMenuGrande(PedidoBuilder builder) {
        builder.reset();
        builder.setPlatoPrincipal(new PlatoPrincipal("Hamburguesa Grande", 50));
        builder.setAcompanamiento(new Acompanamiento("Papas Grandes", 20));
        builder.setBebida(new Bebida("Soda Grande", 15));
        builder.setExtra(new Extra("Juguete", 10));
    }

    public void makeMenuSimple(PedidoBuilder builder) {
        // Similar
    }

    public void makeMenuCompleto(PedidoBuilder builder) {
        // Similar
    }
}
