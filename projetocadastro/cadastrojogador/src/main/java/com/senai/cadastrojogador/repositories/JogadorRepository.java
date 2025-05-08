package com.senai.cadastrojogador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.cadastrojogador.entitites.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {}


