package br.com.joalheriajoiasjoia.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.joalheriajoiasjoia.app.entities.Pedra;
import br.com.joalheriajoiasjoia.app.services.PedraService;

@Controller
@RequestMapping("/pedra")
public class PedraController {
	@Autowired
	private PedraService pedraService;

	@PostMapping
	public Pedra createPedra(@RequestBody Pedra pedra) {
		return pedraService.savePedra(pedra);
	}

	@GetMapping
	public List<Pedra> getAllPedra() {
		return pedraService.getAllPedra();
	}

	@GetMapping("/{id}")
	public Pedra getPedra(@PathVariable Long id) {
		return pedraService.getPedraById(id);
	}

	@PutMapping
	public Pedra editPedra(@RequestBody Pedra pedra) {
		return pedraService.savePedra(pedra);
	}

	@DeleteMapping("/{id}")
	public void deletePedra(@PathVariable Long id) {
		pedraService.deletePedra(id);
	}

}
