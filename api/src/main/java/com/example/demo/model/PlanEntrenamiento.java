package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private Date fecha_inicio;
	//private Usuario corredor;	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "plan_sesiones",
            joinColumns = @JoinColumn(name = "plan_id"),
            inverseJoinColumns = @JoinColumn(name = "sesion_id")
    )
    private List<Sesion> sesiones = new ArrayList<>();

	
	public PlanEntrenamiento() {
	
	}
	
	public PlanEntrenamiento(String nombre, Long kms, String observaciones, Date fecha_inicio, List<Sesion> sesiones) {
		super();
		this.nombre = nombre;
		this.kms = kms;
		this.observaciones = observaciones;
		this.fecha_inicio = fecha_inicio;
		this.sesiones = sesiones;
	}
	public PlanEntrenamiento(String nombre, Long kms, String observaciones) {
		super();
		this.nombre = nombre;
		this.kms = kms;
		this.observaciones = observaciones;
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
/*
	public Usuario getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Usuario entrenador) {
		this.entrenador = entrenador;
	}
*/
	public List<Sesion> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<Sesion> sesiones) {
		this.sesiones = sesiones;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
}
