package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity // Esto le dice a Hibernate que haga una tabla de esta clase
@Table(name = "rutina")
public class Rutina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	private Long kms_objetivo;
	private Date fecha_competicion;
	private String observaciones;
	private Usuario corredor;
	private Usuario entrenador;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "id_plan" )
	private PlanEntrenamiento plan;

	public Rutina() {
	
	}

	public Rutina(String nombre, Long kms_objetivo, Date fecha_competicion, String observaciones, Usuario corredor,
			Usuario entrenador, PlanEntrenamiento plan) {
		super();
		this.nombre = nombre;
		this.kms_objetivo = kms_objetivo;
		this.fecha_competicion = fecha_competicion;
		this.observaciones = observaciones;
		this.corredor = corredor;
		this.entrenador = entrenador;
		this.plan = plan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getKms_objetivo() {
		return kms_objetivo;
	}

	public void setKms_objetivo(Long kms_objetivo) {
		this.kms_objetivo = kms_objetivo;
	}

	public Date getFecha_competicion() {
		return fecha_competicion;
	}

	public void setFecha_competicion(Date fecha_competicion) {
		this.fecha_competicion = fecha_competicion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Usuario getCorredor() {
		return corredor;
	}

	public void setCorredor(Usuario corredor) {
		this.corredor = corredor;
	}

	public Usuario getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Usuario entrenador) {
		this.entrenador = entrenador;
	}

	public PlanEntrenamiento getPlan() {
		return plan;
	}

	public void setPlan(PlanEntrenamiento plan) {
		this.plan = plan;
	}
	
	
	

}
