package com.Restaurante.Restaurante.repository;

import com.Restaurante.Restaurante.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Long> {

}
