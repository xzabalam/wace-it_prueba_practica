package com.wace.it.waceit_evaluacion_tecnica.data.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "usuario_rol")
public class UsuarioRol implements Serializable {

	private static final long serialVersionUID = 7633379909000709682L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "rol_id", referencedColumnName = "id")
	private Rol rol;

	public UsuarioRol() {
	}

	public UsuarioRol(Usuario usuario, Rol rol) {
		this.usuario = usuario;
		this.rol = rol;
	}

}
