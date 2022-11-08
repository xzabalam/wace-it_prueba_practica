package com.wace.it.waceit_evaluacion_tecnica.bussiness.services;

import java.util.List;
import java.util.Optional;

import com.wace.it.waceit_evaluacion_tecnica.data.entities.Usuario;
import com.wace.it.waceit_evaluacion_tecnica.data.repositories.UsuarioRepository;
import com.wace.it.waceit_evaluacion_tecnica.data.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioRolRepository usuarioRolRepository;

	/**
	 * Permite crear un usuario en la base de datos
	 *
	 * @param usuario TO que contiene toda la informaci[on de un uusario.
	 *
	 * @return el usuario creado.
	 */
	public Usuario createUser(Usuario usuario) {
		final Optional<Usuario> result = usuarioRepository.findByUsername(usuario.getUsername());

		if (result.isPresent()) {
			return result.get();
		}

		return usuarioRepository.save(usuario);
	}

	public Usuario getUserByCedulaEstudiante(String cedula) {
		return usuarioRepository.findByCedulaEstudiante(cedula)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("{service.usuario.por.cedula.no.existe}", cedula)));
	}

	public Usuario getUserByEstudianteId(Long empleadoId) {
		return usuarioRepository.findByEstudianteId(empleadoId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("{service.usuario.no.existe}", empleadoId)));
	}

	public Usuario getUserById(Long userId) {
		return usuarioRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("{service.usuario.no.existe}", userId)));
	}

	public Usuario getUserByUsername(String username) {
		return usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("{service.usuario.no.existe}", username)));
	}

	public Page<Usuario> getUsuarios(int page, int size) {
		return usuarioRepository.findAll(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "username")));
	}

	public List<Usuario> getUsuariosByRol(String rol) {
		return usuarioRolRepository.findUsersByRol(rol);
	}
}
