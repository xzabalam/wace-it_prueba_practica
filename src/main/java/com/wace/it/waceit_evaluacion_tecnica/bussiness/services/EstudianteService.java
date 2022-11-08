package com.wace.it.waceit_evaluacion_tecnica.bussiness.services;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.wace.it.waceit_evaluacion_tecnica.bussiness.services.builder.UsuarioBuilder;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.Estudiante;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.Usuario;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.UsuarioRol;
import com.wace.it.waceit_evaluacion_tecnica.data.repositories.EstudianteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;



@Service
public class EstudianteService {

	private static final Logger log = LoggerFactory.getLogger(EstudianteService.class);

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRolService usuarioRolService;

	@Secured({ "ROLE_ADMININISTRADOR" })
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Estudiante createEstudiante(Estudiante estudiante) {
		final Optional<Estudiante> result = estudianteRepository.findByCedula(estudiante.getCedula());

		if (result.isPresent()) {
			return result.get();
		}

		// Creamos el usuario que se relacionará al estudiante.
		final Usuario usuario = UsuarioBuilder.newBuilder().nombres(estudiante.getNombres())
				.apellidos(estudiante.getApellidos()).build();

		estudiante.setUsuario(usuario);

		final UsuarioRol crearUsuarioRolEstudiante = usuarioRolService.crearUsuarioRolEstudiante(usuario);
		log.info(crearUsuarioRolEstudiante.toString());

		return estudianteRepository.save(estudiante);
	}


	@Secured({ "ROLE_ADMININISTRADOR", "ROL_EMPLEADO" })
	public Estudiante getEstudiantePorCedula(String cedula) {
		return estudianteRepository.findByCedula(cedula)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("{service.estudiante.no.existe.por.cedula}", cedula)));
	}

	@Secured({ "ROLE_ADMININISTRADOR", "ROL_EMPLEADO" })
	public Estudiante getEstudiantePorId(Long idEstudiante) {
		return estudianteRepository.findById(idEstudiante)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("{service.estudiante.no.existe.por.id}", idEstudiante)));
	}

	@Secured({ "ROLE_ADMININISTRADOR", "ROL_EMPLEADO" })
	public Estudiante getEstudiantePorNombreYApellido(String nombres, String apellidos) {
		return estudianteRepository.findByNombresAndApellidos(nombres, apellidos)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("{service.estudiante.no.existe.por.nombres.apellidos}", nombres, apellidos)));
	}

	@Secured({ "ROLE_ADMININISTRADOR", "ROL_EMPLEADO" })
	public Estudiante getEstudiantePorUsername(String username) {
		return estudianteRepository.findByUsername(username)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						String.format("{service.estudiante.no.existe.por.username}", username)));
	}
}
