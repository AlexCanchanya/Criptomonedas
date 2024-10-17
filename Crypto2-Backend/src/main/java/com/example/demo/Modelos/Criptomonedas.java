package com.example.demo.Modelos;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="criptomonedas")
public class Criptomonedas {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long crypto_id;

    private String nombre;
    private String simbolo;
    
    private BigDecimal precio_actual; 
    private BigDecimal capitalizacion_de_mercado; 
    private BigDecimal circulacion_actual; 
    
	public Criptomonedas() {
		super();
	}

	public Criptomonedas(Long crypto_id, String nombre, String simbolo, BigDecimal precio_actual,
			BigDecimal capitalizacion_de_mercado, BigDecimal circulacion_actual) {
		super();
		this.crypto_id = crypto_id;
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.precio_actual = precio_actual;
		this.capitalizacion_de_mercado = capitalizacion_de_mercado;
		this.circulacion_actual = circulacion_actual;
	}

	public Long getCrypto_id() {
		return crypto_id;
	}

	public void setCrypto_id(Long crypto_id) {
		this.crypto_id = crypto_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public BigDecimal getPrecio_actual() {
		return precio_actual;
	}

	public void setPrecio_actual(BigDecimal precio_actual) {
		this.precio_actual = precio_actual;
	}

	public BigDecimal getCapitalizacion_de_mercado() {
		return capitalizacion_de_mercado;
	}

	public void setCapitalizacion_de_mercado(BigDecimal capitalizacion_de_mercado) {
		this.capitalizacion_de_mercado = capitalizacion_de_mercado;
	}

	public BigDecimal getCirculacion_actual() {
		return circulacion_actual;
	}

	public void setCirculacion_actual(BigDecimal circulacion_actual) {
		this.circulacion_actual = circulacion_actual;
	}
	
    
}
