package com.senai.cadastropessoa.controllers;

import com.senai.cadastropessoa.entities.Pessoa;
import com.senai.cadastropessoa.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    // Criar uma nova pessoa
    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

    // Buscar uma pessoa pelo ID
    @GetMapping("/{id}")
    public Pessoa buscarPorId(@PathVariable Long id) {
        return pessoaService.buscarPorId(id);
    }

    // Atualizar uma pessoa
    @PutMapping("/{id}")
    public Pessoa atualizar(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
        return pessoaService.atualizar(id, pessoaAtualizada);
    }

    // Excluir uma pessoa
    @DeleteMapping("/{id}")
    public boolean excluir(@PathVariable Long id) {
        return pessoaService.excluir(id);
    }

    // Listar todas as pessoas
    @GetMapping
    public List<Pessoa> listarTodas() {
        return pessoaService.listarTodas();
    }

    // Buscar pessoa por email
    @GetMapping("/email/{email}")
    public Pessoa buscarPorEmail(@PathVariable String email) {
        return pessoaService.buscarPorEmail(email);
    }
    
    // Método de login
    @PostMapping("/login")
    public Pessoa login(@RequestBody Pessoa loginRequest) {
        // Chama o serviço para verificar as credenciais
        Pessoa pessoa = pessoaService.autenticarPessoa(loginRequest.getEmail(), loginRequest.getSenha());

        if (pessoa != null) {
            return pessoa;  // Retorna OK se o login for bem-sucedido
        }
        return null;  // Retorna erro caso contrário
    }
    
}
