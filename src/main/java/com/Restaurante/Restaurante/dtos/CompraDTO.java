package com.Restaurante.Restaurante.dtos;

import lombok.Data;

@Data
public class CompraDTO {
    private Long clienteId;
    private Long contaId;
    private String nomeProduto;
    private Double precoUnitario;
    private Integer quantidade;
}