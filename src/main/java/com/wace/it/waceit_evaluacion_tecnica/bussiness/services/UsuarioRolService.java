package com.wace.it.waceit_evaluacion_tecnica.bussiness.services;

import java.util.Optional;

import com.wace.it.waceit_evaluacion_tecnica.data.entities.Rol;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.Usuario;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.UsuarioRol;
import com.wace.it.waceit_evaluacion_tecnica.data.enums.RolEnum;
import com.wace.it.waceit_evaluacion_tecnica.data.repositories.RolRepository;
import com.wace.it.waceit_evaluacion_tecnica.data.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UsuarioRolService {

	@Autowired
	private UsuarioRolRepository usuarioRolRepository;

	@Autowired
	private RolRepository rolRepository;

	public UsuarioRol crearUsuarioRol(UsuarioRol usuarioRol) {
		return usuarioRolRepository.save(usuarioRol);
	}

	public UsuarioRol crearUsuarioRolEstudiante(Usuario usuario) {
		final Optional<Rol> rolEstudiante = rolRepository.findByNombre(RolEnum.ESTUDIANTE.name());

		if (rolEstudiante.isPresent()) {
			final UsuarioRol usuarioRolEstudiante = new UsuarioRol(usuario, rolEstudiante.get());
						return crearUsuarioRol(usuarioRolEstudiante);
		}

		throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				String.format("El rol %s no existe", RolEnum.ESTUDIANTE.name()));
	}
}
