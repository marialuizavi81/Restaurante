package com.Restaurante.Restaurante.service;

import com.Restaurante.Restaurante.dto.PedidoDTO;
import com.Restaurante.Restaurante.model.Pedido;
import com.Restaurante.Restaurante.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public ResponseEntity<List<PedidoDTO>> exibirPedidos(){
        List<Pedido> pedidos = pedidoRepository.findAll();
        List<PedidoDTO> dtos = pedidos.stream()
                .map(PedidoDTO::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO dto) {
        Pedido pedido = new Pedido();
        Pedido salvo = pedidoRepository.save(pedido);
        return ResponseEntity.ok(new PedidoDTO(salvo));
    }

}
