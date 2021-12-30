package com.example.demo.model;

import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;
	private String contraseña;
	private String email;

	@OneToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;

	public Usuario(Long id, String nombre, String contraseña, String email, Rol rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.email = email;
		this.rol = rol;
	}

	
	public Usuario(String nombre, String contraseña, String email, Rol rol) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.email = email;
		this.rol = rol;
	}

	public Usuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
