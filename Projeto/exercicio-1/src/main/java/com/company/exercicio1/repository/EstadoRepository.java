package com.company.exercicio1.repository;

import com.company.exercicio1.modelo.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByRegiao(String regiao);
}