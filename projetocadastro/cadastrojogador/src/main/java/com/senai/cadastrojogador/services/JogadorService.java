package com.senai.cadastrojogador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastrojogador.entitites.Jogador;
import com.senai.cadastrojogador.repositories.JogadorRepository;

	@Service
	public class JogadorService {

	    @Autowired
	    private JogadorRepository jogadorRepository;

	    // Criar uma nova pessoa
	    public Jogador salvar(Jogador jogador) {
	        return jogadorRepository.save(jogador);
	    }

	    // Buscar uma pessoa pelo ID
	    public Jogador buscarPorId(Long id) {
	        Optional<Jogador> jogador = jogadorRepository.findById(id);
	        return jogador.orElse(null); // Retorna null se a pessoa não for encontrada
	    }

	    // Atualizar os dados de uma pessoa
	    public Jogador atualizar(Long id, Jogador jogadorAtualizada) {
	        if (jogadorRepository.existsById(id)) {
	            jogadorAtualizada.setIdJogador(id);
	            return jogadorRepository.save(jogadorAtualizada);
	        }
	        return null; // Retorna null se a pessoa não for encontrada
	    }

	    // Excluir uma pessoa
	    public boolean excluir(Long id) {
	        if (jogadorRepository.existsById(id)) {
	            jogadorRepository.deleteById(id);
	            return true;
	        }
	        return false; // Retorna false se a pessoa não for encontrada
	    }

	    // Listar todas as pessoas
	    public List<Jogador> listarTodas() {
	        return jogadorRepository.findAll();
	    }
}
