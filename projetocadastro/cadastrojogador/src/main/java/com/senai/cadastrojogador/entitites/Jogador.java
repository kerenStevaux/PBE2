package com.senai.cadastrojogador.entitites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bd_jogador")
public class Jogador {
	//Atributos
	
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private Long idJogador;
			
			@Column(name = "nome_jogador")
			private String nomeJogador;
			
			@Column(name = "idade")
			private String idade;
			
		//construtores 
			Jogador(){
				
			}
			
			Jogador(Long idJogador, String nomeJogador, String idade){
				this.idJogador = idJogador;
				this.nomeJogador = nomeJogador;
				this.idade = idade;
			}

			
			//getters and setters 
			public Long getIdJogador() {
				return idJogador;
			}

			public void setIdJogador(Long idJogador) {
				this.idJogador = idJogador;
			}

			public String getNomeJogador() {
				return nomeJogador;
			}

			public void setNomeJogador(String nomeJogador) {
				this.nomeJogador = nomeJogador;
			}

			public String getIdade() {
				return idade;
			}

			public void setIdade(String idade) {
				this.idade = idade;
			}
		
			

}
