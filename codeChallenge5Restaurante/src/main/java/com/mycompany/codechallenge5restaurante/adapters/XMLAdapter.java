package com.mycompany.codechallenge5restaurante.adapters;

public class XMLAdapter {
    public String convertirJSONaXML(String jsonPedido) {
        return "<pedido><datos>" + jsonPedido + "</datos></pedido>";
    }

    public void enviarPedido(String xmlPedido) {
        System.out.println("Pedido enviado a la cocina: " + xmlPedido);
    }
}
