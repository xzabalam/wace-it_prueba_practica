package com.wace.it.waceit_evaluacion_tecnica.data.entities;

import java.io.Serializable;
import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;

@Entity
@Table(name = "estudiante", uniqueConstraints = { @UniqueConstraint(columnNames = { "cedula" }) })
@Data
@JsonInclude(Include.NON_NULL)
public class Estudiante implements Serializable {
	private static final long serialVersionUID = 8900563733831336123L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cedula", nullable = false)
	private String cedula;

	@NotEmpty
	@Column(name = "nombres", nullable = false)
	@Size(min = 3, max = 500, message = "{entity.empleado.nombre.size}")
	@Pattern(regexp = "^[A-Za-z ]*$", message = "{entity.empleado.solo.letras}")
	private String nombres;

	@NotEmpty
	@Column(name = "apellidos", nullable = false)
	@Size(min = 3, max = 500, message = "{entity.empleado.apellido.size}")
	@Pattern(regexp = "^[A-Za-z ]*$", message = "{entity.empleado.solo.letras}")
	private String apellidos;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonIgnore
	private Usuario usuario;
}
