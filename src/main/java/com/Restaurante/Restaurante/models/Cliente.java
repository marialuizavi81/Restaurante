package com.Restaurante.Restaurante.models;


import jakarta.persistence.*;

import lombok.*;


@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double carteira;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;
}