package com.mycompany.codechallenge5restaurante.comandos;

import com.mycompany.codechallenge5restaurante.adapters.XMLAdapter;
import com.mycompany.codechallenge5restaurante.pedidos.Pedido;

public class EnviarPedidoCocina implements Comando {
    private Pedido pedido;
    private XMLAdapter adapter;

    public EnviarPedidoCocina(Pedido pedido, XMLAdapter adapter) {
        this.pedido = pedido;
        this.adapter = adapter;
    }

    public void ejecutar() {
        String jsonPedido = pedido.toJSON();
        String xmlPedido = adapter.convertirJSONaXML(jsonPedido);
        adapter.enviarPedido(xmlPedido);
        pedido.marcarComoEnviado();
    }

    public void deshacer() {
        pedido.cancelar();
    }
}
