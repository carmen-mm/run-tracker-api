package com.example.demo.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity // Esto le dice a Hibernate que haga una tabla de esta clase
@Table(name = "planEntrenamiento")
public class PlanEntrenamiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;
	private Long kms;
	private String observaciones;
	private Collection<Sesion> sesiones;
	
	public PlanEntrenamiento() {
	
	}
	
	public PlanEntrenamiento(String nombre, Long kms, String observaciones) {
		super();
		this.nombre = nombre;
		this.kms = kms;
		this.observaciones = observaciones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getKms() {
		return kms;
	}
	public void setKms(Long kms) {
		this.kms = kms;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
