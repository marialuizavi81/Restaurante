package com.Restaurante.Restaurante.controller;

import com.Restaurante.Restaurante.dto.PedidoDTO;
import com.Restaurante.Restaurante.model.Pedido;
import com.Restaurante.Restaurante.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurante/pedidos")
@AllArgsConstructor
public class PedidoController {

    private PedidoService pedidoService;

    // CREATE
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        Pedido novoPedido = pedidoService.criarPedido(pedidoDTO);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

    // READ - Buscar todos
    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);

    }
//
//    // READ - Buscar por ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Long id) {
//        Pedido pedido = pedidoService.buscarPedidoPorId(id);
//        return new ResponseEntity<>(pedido, HttpStatus.OK);
//    }
//
//    // UPDATE
//    @PutMapping("/{id}")
//    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
//        Pedido pedidoAtualizado = pedidoService.atualizarPedido(id, pedidoDTO);
//        return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK);
//    }
//
//    // DELETE
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletarPedido(@PathVariable Long id) {
//        pedidoService.deletarPedido(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
