package com.Restaurante.Restaurante.service;

import com.Restaurante.Restaurante.dto.PedidoDTO;
import com.Restaurante.Restaurante.model.Pedido;
import com.Restaurante.Restaurante.repository.PedidoRepository;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido salvarPedido(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();


    }

}
