package com.Restaurante.Restaurante.service;

import com.Restaurante.Restaurante.dtos.CompraDTO;
import com.Restaurante.Restaurante.dtos.PedidoDTO;
import com.Restaurante.Restaurante.models.*;
import com.Restaurante.Restaurante.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaRepository contaRepository;

    public List<PedidoDTO> findAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PedidoDTO findById(Long id) {
        return toDTO(repository.findById(id).orElseThrow());
    }

    public PedidoDTO create(PedidoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow();
        Conta conta = contaRepository.findById(dto.getContaId()).orElseThrow();

        Pedido pedido = new Pedido();
        pedido.setNome(dto.getNome());
        pedido.setPreco(dto.getPreco());
        pedido.setCliente(cliente);
        pedido.setConta(conta);

        return toDTO(repository.save(pedido));
    }

    public PedidoDTO update(Long id, PedidoDTO dto) {
        Pedido pedido = repository.findById(id).orElseThrow();
        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow();
        Conta conta = contaRepository.findById(dto.getContaId()).orElseThrow();

        pedido.setNome(dto.getNome());
        pedido.setPreco(dto.getPreco());
        pedido.setCliente(cliente);
        pedido.setConta(conta);

        return toDTO(repository.save(pedido));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PedidoDTO toDTO(Pedido pedido) {
        return new PedidoDTO(
                pedido.getId(),
                pedido.getNome(),
                pedido.getPreco(),
                pedido.getCliente().getId(),
                pedido.getConta().getId()
        );
    }

    public PedidoDTO realizarCompra(CompraDTO compraDTO) {
        Cliente cliente = clienteRepository.findById(compraDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Conta conta = contaRepository.findById(compraDTO.getContaId())
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));


        if (!cliente.getConta().getId().equals(conta.getId())) {
            throw new RuntimeException("Esta conta não pertence ao cliente especificado");
        }


        Double valorTotal = compraDTO.getPrecoUnitario() * compraDTO.getQuantidade();


        if (conta.getValor() < valorTotal) {
            throw new RuntimeException("Saldo insuficiente na conta");
        }


        conta.setValor(conta.getValor() - valorTotal);
        contaRepository.save(conta);


        Pedido pedido = new Pedido();
        pedido.setNome(compraDTO.getNomeProduto());
        pedido.setPreco(valorTotal);
        pedido.setCliente(cliente);
        pedido.setConta(conta);

        return toDTO(repository.save(pedido));
    }
}