package br.com.joalheriajoiasjoia.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.joalheriajoiasjoia.app.entities.Pedra;

@Repository
public interface PedraRepository extends JpaRepository<Pedra, Long>{
	

}
