package com.senai.cadastrojogador.entitites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bd_jogos")
public class Jogo {
		//Atributos
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idJogo;
		
		@Column(name = "nome_jogo")
		private String nomeJogo;
		
		@Column(name = "ano_lacamento")
		private String anoLancamento;
		
		@ManyToOne
		@JoinColumn(name = "jogadorId")
		private Jogador jogador;
		
		//Construtores
		Jogo(){
			
		}
		
		Jogo(Long idJogo, String nomeJogo, String anoLancamento, Jogador jogador){
			this.idJogo = idJogo;
			this.nomeJogo = nomeJogo;
			this.anoLancamento = anoLancamento;
			this.jogador = jogador;
			
		//getteres and setters
			
		}

		public Long getIdJogo() {
			return idJogo;
		}

		public void setIdJogo(Long idJogo) {
			this.idJogo = idJogo;
		}

		public String getNomeJogo() {
			return nomeJogo;
		}

		public void setNomeJogo(String nomeJogo) {
			this.nomeJogo = nomeJogo;
		}

		public String getAnoLancamento() {
			return anoLancamento;
		}

		public void setAnoLancamento(String anoLancamento) {
			this.anoLancamento = anoLancamento;
		}

		public Jogador getJogador() {
			return jogador;
		}

		public void setJogador(Jogador jogador) {
			this.jogador = jogador;
		}
}


