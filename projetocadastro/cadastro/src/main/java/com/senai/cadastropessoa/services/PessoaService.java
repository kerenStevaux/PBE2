package com.senai.cadastropessoa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.cadastropessoa.entities.Pessoa;
import com.senai.cadastropessoa.repositories.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Criar uma nova pessoa
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    // Buscar uma pessoa pelo ID
    public Pessoa buscarPorId(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElse(null); // Retorna null se a pessoa não for encontrada
    }

    // Atualizar os dados de uma pessoa
    public Pessoa atualizar(Long id, Pessoa pessoaAtualizada) {
        if (pessoaRepository.existsById(id)) {
            pessoaAtualizada.setId(id);
            return pessoaRepository.save(pessoaAtualizada);
        }
        return null; // Retorna null se a pessoa não for encontrada
    }

    // Excluir uma pessoa
    public boolean excluir(Long id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return true;
        }
        return false; // Retorna false se a pessoa não for encontrada
    }

    // Listar todas as pessoas
    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    // Buscar uma pessoa por email
    public Pessoa buscarPorEmail(String email) {
        return pessoaRepository.findByEmail(email);
    }
    
    public Pessoa autenticarPessoa(String email, String senha) {
        Pessoa pessoa = pessoaRepository.findByEmail(email);

        // Verifica se a pessoa existe e se a senha está correta
        if (pessoa != null && pessoa.getSenha().equals(senha)) {
            return pessoa; // Retorna a pessoa se o login for bem-sucedido
        }
        return null; // Retorna null caso contrário
    }
}
