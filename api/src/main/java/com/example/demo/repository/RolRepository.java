package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Rol;


public interface RolRepository  extends JpaRepository <Rol, Long> {
	@Query("select r from Rol r where r.nombre = ?1")
	Rol findRol(String nombre_rol);

}

