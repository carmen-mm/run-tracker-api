package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.service.PlanEntrenamientoServicio;
import com.example.demo.model.PlanEntrenamiento;

@Controller
@RequestMapping("/planes")
public class PlanEntrenamientoControlador {
	@Autowired
	PlanEntrenamientoServicio planEntrenamientoServicio;
		
	@GetMapping(value="/obtenerPlanes")
	public String obtenerPlanes(Model modelo){
		List<PlanEntrenamiento> planes=planEntrenamientoServicio.obtenerPlanes();
		modelo.addAttribute("planes",planes);
		return "obtenerPlanes";
	
	}

	 @PostMapping(value="/guardar")
	 public PlanEntrenamiento guardarPlan(@RequestBody PlanEntrenamiento plan){
	        return this.planEntrenamientoServicio.guardarPlan(plan);
	}
	 
	 @GetMapping(value= "/eliminar/{id}")
		public void eliminarPlan(@PathVariable Long id ){
			planEntrenamientoServicio.eliminarPlan(id);
	
	 }

	 
}
