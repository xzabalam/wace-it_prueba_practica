package com.wace.it.waceit_evaluacion_tecnica.bussiness.services.builder;

import com.wace.it.waceit_evaluacion_tecnica.data.entities.Estudiante;

import java.util.Date;

public class EstudianteBuilder {

	private static Estudiante estudiante;

	public final static EstudianteBuilder newBuilder() {
		estudiante = new Estudiante();
		return new EstudianteBuilder();
	}

	public EstudianteBuilder apellidos(String apellidos) {
		estudiante.setApellidos(apellidos);
		return this;
	}

	public Estudiante build() {
		return estudiante;
	}

	public EstudianteBuilder cedula(String cedula) {
		estudiante.setCedula(cedula);
		return this;
	}

	public EstudianteBuilder nombres(String nombres) {
		estudiante.setNombres(nombres);
		return this;
	}
}
