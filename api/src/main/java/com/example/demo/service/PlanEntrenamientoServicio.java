package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.PlanEntrenamiento;
import com.example.demo.repository.PlanEntrenamientoRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PlanEntrenamientoServicio{

	@Autowired
	PlanEntrenamientoRepository planEntrenamientoRepository;
	
	public List<PlanEntrenamiento> obtenerPlanes(){
		return planEntrenamientoRepository.findAll();	
	}
	
	public Optional<PlanEntrenamiento> obtenerUno(Long id){
		return planEntrenamientoRepository.findById(id);	
	}
	
	public PlanEntrenamiento guardarPlan (PlanEntrenamiento plan){
		return  planEntrenamientoRepository.save(plan);
	}
	
	public void eliminarPlan (Long id){
		planEntrenamientoRepository.deleteById(id);
	}
	
}
