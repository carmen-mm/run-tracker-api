package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity // Esto le dice a Hibernate que haga una tabla de esta clase
@Table(name = "sesion")
public class Sesion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private Float km_diario;
	private String tiempo;
	private String indicaciones;
	private Boolean estado;
	
	@ManyToMany(mappedBy = "sesiones")
    private List<PlanEntrenamiento> planes = new ArrayList<>();
	
	public Sesion() {

	}
	public Sesion(String nombre, Float km_diario, String tiempo, String indicaciones, Boolean estado) {
		this.nombre = nombre;
		this.km_diario = km_diario;
		this.tiempo = tiempo;
		this.indicaciones = indicaciones;
		this.estado = estado;
	}
	public Float getKm_diario() {
		return km_diario;
	}
	public void setKm_diario(Float km_diario) {
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
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
