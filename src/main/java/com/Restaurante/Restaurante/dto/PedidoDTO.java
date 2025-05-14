package com.Restaurante.Restaurante.dto;

import com.Restaurante.Restaurante.model.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PedidoDTO {

    private Long id;
    private String nome;
    private double preco;


    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.nome = pedido.getNome();
        this.preco = pedido.getPreco();

    }

    public static PedidoDTO toEntity(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoDTO.getId());
        pedido.setNome(pedidoDTO.getNome());
        pedido.setPreco(pedidoDTO.getPreco());
        return pedidoDTO;
    }

}
