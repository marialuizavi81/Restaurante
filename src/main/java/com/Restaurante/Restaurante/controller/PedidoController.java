package com.Restaurante.Restaurante.controller;


import com.Restaurante.Restaurante.dto.PedidoDTO;
import com.Restaurante.Restaurante.model.Pedido;
import com.Restaurante.Restaurante.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurante/pedidos")
@AllArgsConstructor
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> salvarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido novoPedido = pedidoService.salvarPedido(pedidoDTO);
    return new ResponseEntity<>(novoPedido, HttpStatus.CREATED); }

//    @GetMapping
//    public ResponseEntity
}
