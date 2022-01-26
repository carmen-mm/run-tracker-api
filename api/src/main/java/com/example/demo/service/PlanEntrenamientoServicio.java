package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.PlanEntrenamiento;
import com.example.demo.repository.PlanEntrenamientoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PlanEntrenamientoServicio{

	@Autowired
	PlanEntrenamientoRepository planEntranamientoRepositoy;
	
	public List<PlanEntrenamiento> obtenerPlanes(){
		return planEntranamientoRepositoy.findAll();	
	}
	
	public PlanEntrenamiento guardarPlan (PlanEntrenamiento plan){
		return  planEntranamientoRepositoy.save(plan);
	}
	
}
