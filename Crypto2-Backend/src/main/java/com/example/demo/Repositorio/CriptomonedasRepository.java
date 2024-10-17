package com.example.demo.Repositorio;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelos.Criptomonedas;

@Repository
public interface CriptomonedasRepository extends JpaRepository<Criptomonedas, Long> {
    
	boolean existsBySimbolo(String simbolo);
	Optional<Criptomonedas> findBySimbolo(String simbolo);

}