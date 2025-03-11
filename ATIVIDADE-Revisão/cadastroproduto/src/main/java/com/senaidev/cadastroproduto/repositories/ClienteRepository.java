package com.senaidev.cadastroproduto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senaidev.cadastroproduto.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
