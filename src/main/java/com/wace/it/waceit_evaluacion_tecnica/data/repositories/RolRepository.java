package com.wace.it.waceit_evaluacion_tecnica.data.repositories;

import java.util.Optional;

import com.wace.it.waceit_evaluacion_tecnica.data.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

	Optional<Rol> findByNombre(String nombre);
}
