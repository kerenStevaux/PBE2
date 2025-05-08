package com.senai.cadastrojogador.services;

import com.senai.cadastrojogador.entitites.Jogo;
import com.senai.cadastrojogador.entitites.Jogador;
import com.senai.cadastrojogador.repositories.JogoRepository;
import com.senai.cadastrojogador.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogo salvarJogo(Jogo jogo) {
        // Valida se o jogador existe antes de associar
        if (jogo.getJogador() != null) {
            Optional<Jogador> jogadorOptional = jogadorRepository.findById(jogo.getJogador().getIdJogador());
            if (jogadorOptional.isEmpty()) {
                throw new IllegalArgumentException("Jogador com ID " + jogo.getJogador().getIdJogador() + " não encontrado.");
            }
            jogo.setJogador(jogadorOptional.get());
        }
        return jogoRepository.save(jogo);
    }

    public List<Jogo> listarJogos() {
        return jogoRepository.findAll();
    }
}
