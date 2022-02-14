package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Long> {

}
