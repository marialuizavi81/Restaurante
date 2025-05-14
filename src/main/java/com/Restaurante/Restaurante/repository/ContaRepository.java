package com.Restaurante.Restaurante.repository;

import com.Restaurante.Restaurante.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta,Long> {

}
