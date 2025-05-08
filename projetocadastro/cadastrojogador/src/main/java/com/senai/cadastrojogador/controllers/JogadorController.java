package com.senai.cadastrojogador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.cadastrojogador.entitites.Jogador;
import com.senai.cadastrojogador.repositories.JogadorRepository;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

	    @Autowired
	    private JogadorRepository jogadorRepository;

	    @PostMapping
	    public Jogador criarJogador(@RequestBody Jogador jogador) {
	        return jogadorRepository.save(jogador);
	    }

	    @GetMapping
	    public List<Jogador> listarJogadores() {
	        return jogadorRepository.findAll();
	    }
	}


