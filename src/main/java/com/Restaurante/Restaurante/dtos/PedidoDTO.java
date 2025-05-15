package com.Restaurante.Restaurante.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private String nome;
    private Double preco;
    private Long clienteId;
    private Long contaId;
}