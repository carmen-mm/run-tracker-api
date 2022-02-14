package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
	@GetMapping(value="/")
	public List<PlanEntrenamiento> obtenerPlanes(Model modelo){
		return planEntrenamientoServicio.obtenerPlanes();
	}		

	
	@GetMapping(value="/{id}")
	public Optional<PlanEntrenamiento> obtenerUno(@PathVariable Long id ){
			return planEntrenamientoServicio.obtenerUno(id);
	
	 }
	
	 @PostMapping(value="/guardar")
	 public ResponseEntity<PlanEntrenamiento> guardar(@RequestBody PlanEntrenamiento plan){
	        return ResponseEntity.status(HttpStatus.CREATED).body(planEntrenamientoServicio.guardarPlan(plan));
	}
	 
	 @DeleteMapping(value= "/{id}")
		public void eliminarPlan(@PathVariable Long id ){
			planEntrenamientoServicio.eliminarPlan(id);
	
	 }

	 
}
