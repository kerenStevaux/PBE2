package com.senai.cadastrojogador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.cadastrojogador.entitites.Jogo;
import com.senai.cadastrojogador.repositories.JogoRepository;

@RestController
	@RequestMapping("/api/jogos")
	public class JogoController {

	    @Autowired
	    private JogoRepository jogoRepository;

	    @PostMapping
	    public Jogo criarJogo(@RequestBody Jogo jogo) {
	        return jogoRepository.save(jogo);
	    }

	    @GetMapping
	    public List<Jogo> listarJogos() {
	        return jogoRepository.findAll();
	    }
	}

