package com.senaidev.cadastroproduto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senaidev.cadastroproduto.entities.Cliente;
import com.senaidev.cadastroproduto.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteControllers {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteService.saveCliente(cliente);
	}
	
	@GetMapping
	public List<Cliente> getAllCliente(){
		return clienteService.getAllCliente();
	}
}
