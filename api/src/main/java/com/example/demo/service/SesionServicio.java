package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sesion;
import com.example.demo.repository.SesionRepository;

@Service
public class SesionServicio {
	
	@Autowired
	SesionRepository sesionRepository;
	
	public List<Sesion> obtenerPlanes(){
		return sesionRepository.findAll();	
	}
	
	public Optional<Sesion> obtenerUno(Long id){
		return sesionRepository.findById(id);	
	}
	
	public Sesion guardarPlan (Sesion sesion){
		return  sesionRepository.save(sesion);
	}
	
	public void eliminarPlan (Long id){
		sesionRepository.deleteById(id);
	}

}
