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
        this.id = getId();
        this.nome = getNome();
        this.preco = getPreco();

    }
    public Pedido converteToPedido() {
        Pedido novoPedido = new Pedido();
        novoPedido.setId(getId());
        novoPedido.setNome(getNome());
        novoPedido.setPreco(getPreco());
        return novoPedido;
    }

    public PedidoDTO converteToPedidoDTO() {
        PedidoDTO novoPedidoDTO = new PedidoDTO();
        novoPedidoDTO.setId(getId());
        novoPedidoDTO.setNome(getNome());
        novoPedidoDTO.setPreco(getPreco());
        return novoPedidoDTO;

    }
}
