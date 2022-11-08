package com.wace.it.waceit_evaluacion_tecnica.data.repositories;

import java.util.Optional;

import com.wace.it.waceit_evaluacion_tecnica.data.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("select e.usuario from Estudiante e where e.cedula = ?1")
	Optional<Usuario> findByCedulaEstudiante(String cedula);

	@Query("select e.usuario from Estudiante e where e.id = ?1")
	Optional<Usuario> findByEstudianteId(Long empleadoId);

	Optional<Usuario> findByUsername(String username);
}
