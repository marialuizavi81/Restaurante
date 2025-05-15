package com.Restaurante.Restaurante.dtos;

import com.Restaurante.Restaurante.models.Cliente;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {
    private Long id;
    private String nome;
    private Double carteira;
    private Long contaId;
}