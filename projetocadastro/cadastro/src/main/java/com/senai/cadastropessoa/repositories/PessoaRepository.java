package com.senai.cadastropessoa.repositories;

import com.senai.cadastropessoa.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    // Busca a pessoa pelo email
    Pessoa findByEmail(String email);
}
