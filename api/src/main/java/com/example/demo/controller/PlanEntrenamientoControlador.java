package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PlanEntrenamientoServicio;
import com.example.demo.model.PlanEntrenamiento;

@RestController
@RequestMapping("/planes")
public class PlanEntrenamientoControlador {
	@Autowired
	PlanEntrenamientoServicio planEntrenamientoServicio;
		
	@RequestMapping(value="/obtenerPlanes", method=RequestMethod.GET)
	public List<PlanEntrenamiento> obtenerPlanes(Model modelo){
		return planEntrenamientoServicio.obtenerPlanes();
		
		
//		List<PlanEntrenamiento> planes=planEntrenamientoServicio.obtenerPlanes();
//		modelo.addAttribute("planes",planes);
//		try {
//			return "obtenerPlanes";
//			
//		}catch (Exception e) {
//			return ("Error: "+e);
//		}
}	
	
	@RequestMapping(value="/obtenerUno/{id}", method=RequestMethod.GET)
	public Optional<PlanEntrenamiento> obtenerUno(@PathVariable Long id ){
			return planEntrenamientoServicio.obtenerUno(id);
	
	 }
	
	 @RequestMapping(value="/guardar", method=RequestMethod.POST)
	 public PlanEntrenamiento guardar(PlanEntrenamiento plan){
	        return this.planEntrenamientoServicio.guardarPlan(plan);
	}
	 
	 @GetMapping(value= "/eliminar/{id}")
		public void eliminarPlan(@PathVariable Long id ){
			planEntrenamientoServicio.eliminarPlan(id);
	
	 }

	 
}
