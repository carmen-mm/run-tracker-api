package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioServicioImpl;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
	
	@Autowired
	 UsuarioServicioImpl usuarioServicioImpl;
	
	
	@PostMapping("/")
	public void guardarUsuario(@RequestBody Usuario user) {
		usuarioServicioImpl.guardarUsuario(user);
	}
	
	@GetMapping(value="/")
	public List<Usuario> listarUsuarios(Model modelo) {
		return usuarioServicioImpl.listarUsuarios();	
	}
	
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_ADMIN')")
	@GetMapping(value="/{id}")
	public Optional<Usuario> obtenerUno(@PathVariable Long id ){
			return usuarioServicioImpl.obtenerUno(id);
	
	 }
	
	 @DeleteMapping(value= "/{id}")
		public void eliminarUsuario(@PathVariable Long id ){
		 usuarioServicioImpl.eliminarUsuario(id);
	
	 }

}
