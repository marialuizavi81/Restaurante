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

    public ClienteDTO(Cliente cliente){
        this.id = getId();
        this.nome = getNome();
        this.carteira = getCarteira();

    }

    public Cliente converterToCliente(){
        Cliente novoCliente = new Cliente();
        novoCliente.setId(getId());
        novoCliente.setNome(getNome());
        novoCliente.setCarteira(getCarteira());
        return novoCliente;
    }

    public Cliente converteToClienteDTO(){
        Cliente novoClienteDTO = new Cliente();
        novoClienteDTO.setId(getId());
        novoClienteDTO.setNome(getNome());
        novoClienteDTO.setCarteira(getCarteira());
        return novoClienteDTO;
    }

}
