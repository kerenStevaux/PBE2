package com.senai.cadastrojogador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.cadastrojogador.entitites.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long> {}