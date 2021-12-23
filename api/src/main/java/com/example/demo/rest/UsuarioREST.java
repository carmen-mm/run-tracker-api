package com.example.demo.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping ("/usuario")
public class UsuarioREST {
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@GetMapping
	private ResponseEntity<List<Usuario>> getAllUsuarios (){
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Usuario> saveUsuario (@RequestBody Usuario usuario){
		try {
			Usuario usuarioGuardado = usuarioService.save(usuario);		
		return ResponseEntity.created(new URI("/usuarios/"+usuarioGuardado.getId())).body(usuarioGuardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteUsuario (@PathVariable ("id") Long id){
		usuarioService.deleteById(id);
		return ResponseEntity.ok(!(usuarioService.findById(id)!=null));
		
	}
	
	
	
}
