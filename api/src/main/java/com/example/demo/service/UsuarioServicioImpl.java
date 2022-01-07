package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.AuthorityUtils;

import com.example.demo.dto.UsuarioRegistroDto;
import com.example.demo.model.Rol;
import com.example.demo.model.Usuario;
import com.example.demo.repository.RolRepository;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

	private UsuarioRepository usuarioRepository;
	private RolRepository rolRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServicioImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository ) {
		super();
		this.rolRepository = rolRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDto registroDTO) {
		Rol rol = this.rolRepository.findRol(registroDTO.getNombre_rol());
		Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getEmail(), passwordEncoder.encode(registroDTO.getPassword()), rol );
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o contraseña inválidos");
		}
		return new User(usuario.getEmail(), usuario.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("CORREDOR"));
	}

	
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

}
