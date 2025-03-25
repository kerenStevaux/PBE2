package br.com.joalheriajoiasjoia.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedra")
public class Pedra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id_pedra;
	
	@Column
	String tipo_pedra;
	
	@Column
	Double medidas;

	public Pedra() {
		
	}
	public Pedra(Long id_pedra, String tipo_pedra, Double medidas) {
		this.id_pedra = id_pedra;
		this.tipo_pedra = tipo_pedra;
		this.medidas = medidas;
	}
	public Long getId_pedra() {
		return id_pedra;
	}
	public void setId_pedra(Long id_pedra) {
		this.id_pedra = id_pedra;
	}
	public String getTipo_pedra() {
		return tipo_pedra;
	}
	public void setTipo_pedra(String tipo_pedra) {
		this.tipo_pedra = tipo_pedra;
	}
	public Double getMedidas() {
		return medidas;
	}
	public void setMedidas(Double medidas) {
		this.medidas = medidas;
	}
	
	
	
}
