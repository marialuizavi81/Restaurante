package com.Restaurante.Restaurante.service;

import com.Restaurante.Restaurante.dtos.ClienteDTO;
import com.Restaurante.Restaurante.models.Cliente;
import com.Restaurante.Restaurante.models.Conta;
import com.Restaurante.Restaurante.repository.ClienteRepository;
import com.Restaurante.Restaurante.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ContaRepository contaRepository;

    public List<ClienteDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO findById(Long id) {
        return toDTO(repository.findById(id).orElseThrow());
    }

    public ClienteDTO create(ClienteDTO dto) {
        Conta conta = contaRepository.findById(dto.getContaId()).orElseThrow();

        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setCarteira(dto.getCarteira());
        cliente.setConta(conta);

        return toDTO(repository.save(cliente));
    }

    public ClienteDTO update(Long id, ClienteDTO dto) {
        Cliente cliente = repository.findById(id).orElseThrow();
        Conta conta = contaRepository.findById(dto.getContaId()).orElseThrow();

        cliente.setNome(dto.getNome());
        cliente.setCarteira(dto.getCarteira());
        cliente.setConta(conta);

        return toDTO(repository.save(cliente));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCarteira(),
                cliente.getConta().getId()
        );
    }
}