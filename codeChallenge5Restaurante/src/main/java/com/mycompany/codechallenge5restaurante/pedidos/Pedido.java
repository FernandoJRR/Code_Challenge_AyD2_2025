package com.mycompany.codechallenge5restaurante.pedidos;

import com.mycompany.codechallenge5restaurante.productos.Producto;

public class Pedido {
    private Producto platoPrincipal;
    private Producto acompanamiento;
    private Producto bebida;
    private Producto extra;
    private EstadoPedido estado;

    public Pedido(Producto platoPrincipal, Producto acompanamiento, Producto bebida, Producto extra) {
        if (platoPrincipal == null) {
            throw new IllegalArgumentException("El plato principal es obligatorio.");
        }
        this.platoPrincipal = platoPrincipal;
        this.acompanamiento = acompanamiento;
        this.bebida = bebida;
        this.extra = extra;
        this.estado = EstadoPedido.CREADO;
    }

    public void marcarComoEnviado() {
        this.estado = EstadoPedido.ENVIADO;
    }

    public void cancelar() {
        this.estado = EstadoPedido.CANCELADO;
    }

    public String toJSON() {
        return "{ 'platoPrincipal': '" + platoPrincipal.obtenerNombre() + "', 'total': " + calcularTotal() + ", "+"estado: "+this.estado+" }";
    }

    public double calcularTotal() {
        double total = 0;
        total += platoPrincipal.obtenerPrecio();
        if (acompanamiento != null) total += acompanamiento.obtenerPrecio();
        if (bebida != null) total += bebida.obtenerPrecio();
        if (extra != null) total += extra.obtenerPrecio();
        return total;
    }
}
