package com.Restaurante.Restaurante.service;

import com.Restaurante.Restaurante.dtos.*;
import com.Restaurante.Restaurante.models.Conta;
import com.Restaurante.Restaurante.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    private ContaRepository repository;

    public List<ContaDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ContaDTO findById(Long id) {
        return toDTO(repository.findById(id).orElseThrow());
    }

    public ContaDTO create(ContaDTO dto) {
        Conta conta = new Conta();
        conta.setNomeConta(dto.getNomeConta());
        conta.setValor(dto.getValor());
        return toDTO(repository.save(conta));
    }

    public ContaDTO update(Long id, ContaDTO dto) {
        Conta conta = repository.findById(id).orElseThrow();
        conta.setNomeConta(dto.getNomeConta());
        conta.setValor(dto.getValor());
        return toDTO(repository.save(conta));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getId(), conta.getNomeConta(), conta.getValor());
    }
}