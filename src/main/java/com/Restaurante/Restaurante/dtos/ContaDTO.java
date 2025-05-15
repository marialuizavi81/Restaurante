package com.Restaurante.Restaurante.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaDTO {
    private Long id;
    private String nomeConta;
    private Double valor;
}