package com.mycompany.codechallenge5restaurante.pedidos;

import com.mycompany.codechallenge5restaurante.productos.Producto;

public class Pedido {
    private Producto platoPrincipal;
    private Producto acompanamiento;
    private Producto bebida;
    private Producto extra;

    public Pedido(Producto platoPrincipal, Producto acompanamiento, Producto bebida, Producto extra) {
        this.platoPrincipal = platoPrincipal;
        this.acompanamiento = acompanamiento;
        this.bebida = bebida;
        this.extra = extra;
    }

    public double calcularTotal() {
        double total = 0;
        if (platoPrincipal != null) total += platoPrincipal.obtenerPrecio();
        if (acompanamiento != null) total += acompanamiento.obtenerPrecio();
        if (bebida != null) total += bebida.obtenerPrecio();
        if (extra != null) total += extra.obtenerPrecio();
        return total;
    }
}
