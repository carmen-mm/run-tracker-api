package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.dto.UsuarioRegistroDto;
import com.example.demo.model.Usuario;

public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDto registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
