package com.example.demo.dto;

public class UsuarioRegistroDto {

	private String nombre;
	private String email;
	private String password;
	private String nombre_rol;
	

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UsuarioRegistroDto(String nombre, String email,String password, String nombre_rol) {
		
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.nombre_rol = nombre_rol;
	}
	

	public UsuarioRegistroDto() {
	
	}
	public UsuarioRegistroDto(String email) {
		this.email = email;
	}
	public String getNombre_rol() {
		return nombre_rol;
	}
	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}
		
}
