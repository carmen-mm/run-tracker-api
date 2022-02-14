package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.core.authority.AuthorityUtils;


import com.example.demo.model.Rol;
import com.example.demo.model.Usuario;
import com.example.demo.repository.RolRepository;
import com.example.demo.repository.UsuarioRepository;

@Service("userDetailsService")
public class UsuarioServicioImpl implements UsuarioServicio{

	private UsuarioRepository usuarioRepository;
	private RolRepository rolRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;   //encriptador de claves
	
	public UsuarioServicioImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository ) {
		super();
		this.rolRepository = rolRepository;
		this.usuarioRepository = usuarioRepository;
	}


	@Override
	public void guardarUsuario(@RequestBody Usuario user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		usuarioRepository.save(user);
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
	
	@Override
	public Optional<Usuario> obtenerUno(Long id){
		return usuarioRepository.findById(id);	
	}
	
	@Override
	public void eliminarUsuario (Long id){
		usuarioRepository.deleteById(id);
	}

}
