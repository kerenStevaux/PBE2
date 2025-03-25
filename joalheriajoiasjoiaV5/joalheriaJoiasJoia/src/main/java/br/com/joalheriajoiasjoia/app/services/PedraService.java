package br.com.joalheriajoiasjoia.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.joalheriajoiasjoia.app.entities.Pedra;
import br.com.joalheriajoiasjoia.app.repositories.PedraRepository;

@Service
public class PedraService {
	
	@Autowired
	private PedraRepository pedraRepository;
	
	public Pedra savePedra( Pedra pedra) {
		return pedraRepository.save(pedra);
	}
	
	public List<Pedra> getAllPedra(){
		return pedraRepository.findAll();
	}
	
	public Pedra getPedraById (Long id) {
		return pedraRepository.findById(id).orElse(null);
	}
	
	public void deletePedra(Long id) {
		pedraRepository.deleteById(id);
	}
}
