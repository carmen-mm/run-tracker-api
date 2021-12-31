package com.example.demo.dto;

public class UsuarioRegistroDto {

	private Long id;
	private String nombre;
	private String email;
	private String contraseña;
	
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
	public UsuarioRegistroDto(Long id, String nombre, String email,String contraseña) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
	}
	public UsuarioRegistroDto(String nombre,String email, String contraseña) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
	}

	public UsuarioRegistroDto() {
	
	}
	public UsuarioRegistroDto(String email) {
		super();
		this.email = email;
	}
	
	
	
}
