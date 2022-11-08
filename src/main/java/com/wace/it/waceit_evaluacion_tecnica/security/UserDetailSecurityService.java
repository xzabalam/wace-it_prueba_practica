package com.wace.it.waceit_evaluacion_tecnica.security;

import java.util.List;
import java.util.Optional;

import com.wace.it.waceit_evaluacion_tecnica.data.entities.Usuario;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.UsuarioRol;
import com.wace.it.waceit_evaluacion_tecnica.data.repositories.UsuarioRepository;
import com.wace.it.waceit_evaluacion_tecnica.data.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailSecurityService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioRolRepository userInRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final Optional<Usuario> optionalUser = usuarioRepository.findByUsername(username);

		if (optionalUser.isPresent()) {
			final Usuario usuario = optionalUser.get();
			final List<UsuarioRol> listaUsuarioRol = userInRoleRepository.findByUsername(usuario.getUsername());
			final String[] roles = listaUsuarioRol.stream().map(usuarioRol -> usuarioRol.getRol().getNombre())
					.toArray(String[]::new);
			return User.withUsername(usuario.getUsername()).password(usuario.getPassword()).roles(roles).build();
		}

		throw new UsernameNotFoundException(String.format("{security.usuario.no.encontrado}", username));
	}
}
