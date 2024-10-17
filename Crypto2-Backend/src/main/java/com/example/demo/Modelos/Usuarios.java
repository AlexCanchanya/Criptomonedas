package com.example.demo.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String nombre_usuario;
    private String correo_electronico;
    private String contraseña;
	
    public Usuarios() {
		super();
	}

	public Usuarios(Long user_id, String nombre_usuario, String correo_electronico, String contraseña) {
		super();
		this.user_id = user_id;
		this.nombre_usuario = nombre_usuario;
		this.correo_electronico = correo_electronico;
		this.contraseña = contraseña;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
    
    
}