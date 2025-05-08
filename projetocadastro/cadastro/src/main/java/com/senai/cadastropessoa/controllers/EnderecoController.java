package com.senai.cadastropessoa.controllers;

import com.senai.cadastropessoa.entities.Endereco;
import com.senai.cadastropessoa.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    // Endpoint para salvar um novo endereço
    @PostMapping
    public Endereco salvarEndereco(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }

    // Endpoint para listar todos os endereços
    @GetMapping
    public List<Endereco> listarEnderecos() {
        return enderecoService.listarTodos();
    }

    // Endpoint para buscar um endereço específico por ID
    @GetMapping("/{id}")
    public Endereco buscarEnderecoPorId(@PathVariable Long id) {
        return enderecoService.buscarPorId(id).orElse(null);
    }

    // Endpoint para deletar um endereço por ID
    @DeleteMapping("/{id}")
    public void deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarPorId(id);
    }
}
