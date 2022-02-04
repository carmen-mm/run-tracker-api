package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.PlanEntrenamiento;
import com.example.demo.repository.PlanEntrenamientoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PlanEntrenamientoServicio{

	@Autowired
	PlanEntrenamientoRepository planEntrenamientoRepositoy;
	
	public List<PlanEntrenamiento> obtenerPlanes(){
		return planEntrenamientoRepositoy.findAll();	
	}
	
	public PlanEntrenamiento guardarPlan (PlanEntrenamiento plan){
		return  planEntrenamientoRepositoy.save(plan);
	}
	
	public void eliminarPlan (Long id){
		planEntrenamientoRepositoy.deleteById(id);
	}
	
}
