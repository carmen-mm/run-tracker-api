package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping ("/usuario")
public class UsuarioREST {
	
	@Autowired
	private UsuarioService usuarioService; 
}
