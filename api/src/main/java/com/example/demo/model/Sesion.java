package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // Esto le dice a Hibernate que haga una tabla de esta clase
@Table(name = "sesion")
public class Sesion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private Long km_diario;
	private String tiempo;
	private String indicaciones;
	private Boolean listo;
	
	public Sesion() {

	}
	public Sesion(String nombre, Long km_diario, String tiempo, String indicaciones, Boolean listo) {
		super();
		this.nombre = nombre;
		this.km_diario = km_diario;
		this.tiempo = tiempo;
		this.indicaciones = indicaciones;
		this.listo = listo;
	}
	public Long getKm_diario() {
		return km_diario;
	}
	public void setKm_diario(Long km_diario) {
		this.km_diario = km_diario;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getIndicaciones() {
		return indicaciones;
	}
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
	public Boolean getListo() {
		return listo;
	}
	public void setListo(Boolean listo) {
		this.listo = listo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
