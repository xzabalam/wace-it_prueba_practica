package com.wace.it.waceit_evaluacion_tecnica.data.repositories;

import java.util.List;
import java.util.Optional;

import com.wace.it.waceit_evaluacion_tecnica.data.entities.Usuario;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {

	@Query("select ur from UsuarioRol ur where ur.usuario.username = ?1")
	List<UsuarioRol> findByUsername(String username);

	@Query("select ur from UsuarioRol ur where ur.usuario.username = ?1 and ur.rol.nombre = ?2")
	Optional<UsuarioRol> findByUsernameAndRol(String username, String rol);

	List<UsuarioRol> findByUsuarioId(Long usuarioId);

	@Query("select ur.usuario from UsuarioRol ur where ur.rol.nombre = ?1")
	List<Usuario> findUsersByRol(String rol);
}
