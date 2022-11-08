package com.wace.it.waceit_evaluacion_tecnica.data.repositories;

import java.util.Optional;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>, JpaSpecificationExecutor<Estudiante> {

	@Query("select e from Estudiante e where e.cedula = ?1 ")
	Optional<Estudiante> findByCedula(String cedula);

	Optional<Estudiante> findByNombresAndApellidos(String nombres, String apellidos);

	@Query("select e from Estudiante e where e.usuario.username = ?1 ")
	Optional<Estudiante> findByUsername(String username);

}
