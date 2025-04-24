package com.mycompany.codechallenge5restaurante.pedidos;

import com.mycompany.codechallenge5restaurante.productos.Producto;

public class PedidoBuilder {
    private Producto platoPrincipal;
    private Producto acompanamiento;
    private Producto bebida;
    private Producto extra;

    public void reset() {
        this.platoPrincipal = null;
        this.acompanamiento = null;
        this.bebida = null;
        this.extra = null;
    }

    public void setPlatoPrincipal(Producto platoPrincipal) {
        this.platoPrincipal = platoPrincipal;
    }

    public void setAcompanamiento(Producto acompanamiento) {
        this.acompanamiento = acompanamiento;
    }

    public void setBebida(Producto bebida) {
        this.bebida = bebida;
    }

    public void setExtra(Producto extra) {
        this.extra = extra;
    }

    public Pedido getResult() {
        return new Pedido(platoPrincipal, acompanamiento, bebida, extra);
    }
}
