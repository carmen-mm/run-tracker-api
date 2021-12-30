package com.example.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsuarioRegistroDto;
import com.example.demo.model.Rol;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServicioImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDto registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getEmail(), passwordEncoder.encode(registroDTO.getContraseña()),new Rol("ADMIN"));
		return usuarioRepository.save(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o contraseña inválidos");
		}
		return new User(usuario.getEmail(),usuario.getContraseña(), (Collection<? extends GrantedAuthority>) usuario.getRol());
	}

/*	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Rol rol){
		return ((Object) rol.stream()).map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
	}*/
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

}
