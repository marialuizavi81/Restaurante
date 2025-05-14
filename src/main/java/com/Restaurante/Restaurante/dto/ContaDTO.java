package com.Restaurante.Restaurante.dto;

import com.Restaurante.Restaurante.model.Conta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContaDTO {

    private Long idConta;
    private String nomeConta;
    private double Valor;

    public ContaDTO(Conta conta ) {
        this.idConta = conta.getIdConta();
        this.nomeConta = conta.getNomeConta();
        this.Valor = conta.getValor();
    }

    public static Conta toEntity(ContaDTO contaDTO) {
        Conta conta = new Conta();
        conta.setIdConta(contaDTO.getIdConta());
        conta.setNomeConta(contaDTO.getNomeConta());
        conta.setValor(contaDTO.getValor());
        return conta;
    }

}
