package com.Restaurante.Restaurante.controller;

import com.Restaurante.Restaurante.dto.ClienteDTO;
import com.Restaurante.Restaurante.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> exibirCliente() {
        return clienteService.exibirCliente();
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> salvarCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.salvarCliente(clienteDTO);
    }

}
