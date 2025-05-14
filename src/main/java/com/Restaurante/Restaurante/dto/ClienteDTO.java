package com.Restaurante.Restaurante.dto;

import com.Restaurante.Restaurante.model.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private double carteira;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.carteira = cliente.getCarteira();
    }

    public static Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setCarteira(clienteDTO.getCarteira());
        return cliente;
    }


}
