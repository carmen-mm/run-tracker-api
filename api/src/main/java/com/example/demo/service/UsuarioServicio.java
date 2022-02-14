package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.Usuario;

public interface UsuarioServicio extends UserDetailsService{

	public void guardarUsuario(@RequestBody Usuario user);
	
	public List<Usuario> listarUsuarios();
	
	public Optional<Usuario> obtenerUno(Long id);
	
	public void eliminarUsuario (Long id);
	
}
