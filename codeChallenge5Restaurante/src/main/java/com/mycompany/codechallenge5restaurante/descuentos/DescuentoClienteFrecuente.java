package com.mycompany.codechallenge5restaurante.descuentos;

public class DescuentoClienteFrecuente implements DescuentoStrategy {
    public double aplicarDescuento(double total) {
        return total * 0.90; // 10% descuento
    }
}
