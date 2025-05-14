package com.Restaurante.Restaurante.service;

import com.Restaurante.Restaurante.dto.ClienteDTO;
import com.Restaurante.Restaurante.model.Cliente;
import com.Restaurante.Restaurante.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository ClienteRepository;

    public ResponseEntity<List<ClienteDTO>> exibirCliente() {
        List<Cliente> clientes = ClienteRepository.findAll();
        List<ClienteDTO> dtos = clientes.stream()
                .map(ClienteDTO::new)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity<ClienteDTO> salvarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = ClienteDTO.toEntity(clienteDTO);
        Cliente salvo = ClienteRepository.save(cliente);
        return ResponseEntity.ok(new ClienteDTO(salvo));
    }
}
