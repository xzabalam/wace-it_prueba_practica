package com.wace.it.waceit_evaluacion_tecnica.data.entities;

import lombok.Data;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = -7310305185273678943L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(name = "username", nullable = false)
	@Size(min = 5, max = 20, message = "{entity.auditoria.username}")
	private String username;

	@NotEmpty
	// @PasswordValido
	@Column(name = "password", nullable = false)
	private String password;

	public Usuario() {
	}

	public Usuario(@NotEmpty @Size(min = 10, max = 20, message = "{entity.auditoria.username}") String username,
				   @NotEmpty String password) {
		this.username = username;
		this.password = password;
	}
}
