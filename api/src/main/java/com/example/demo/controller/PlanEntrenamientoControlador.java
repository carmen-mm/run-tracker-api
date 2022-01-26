package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PlanEntrenamientoServicio;
import com.example.demo.model.PlanEntrenamiento;

@RestController
@RequestMapping("/planes")
public class PlanEntrenamientoControlador {
	@Autowired
	PlanEntrenamientoServicio planEntrenamientoServicio;
	
	@GetMapping()
	public List<PlanEntrenamiento> obtenerPlanes(){
		return planEntrenamientoServicio.obtenerPlanes();
	}

	 @PostMapping()
	 public PlanEntrenamiento guardarPlan(@RequestBody PlanEntrenamiento plan){
	        return this.planEntrenamientoServicio.guardarPlan(plan);
	    }
}
