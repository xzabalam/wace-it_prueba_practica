package com.wace.it.waceit_evaluacion_tecnica.data.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "rol")
public class Rol  implements Serializable {

	private static final long serialVersionUID = -2444040665252984879L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "nombre", nullable = false)
	@Size(min = 4, max = 20, message = "{entity.rol.nombre.size}")
	private String nombre;

	@NotEmpty
	@Column(name = "descripcion", nullable = false)
	@Size(min = 3, max = 250, message = "{entity.rol.descripcion.size}")
	private String descripcion;


}
