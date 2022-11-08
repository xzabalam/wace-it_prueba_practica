package com.wace.it.waceit_evaluacion_tecnica.bussiness.services.builder;

import com.wace.it.waceit_evaluacion_tecnica.data.entities.Rol;

import java.util.Date;


public class RolBuilder {

	private static Rol rol;

	public static RolBuilder newBuilder() {
		rol = new Rol();
		return new RolBuilder();
	}

	public Rol build() {
		return rol;
	}

	public RolBuilder descripcion(String nombre) {
		rol.setDescripcion(nombre);
		return this;
	}

	public RolBuilder nombre(String nombre) {
		rol.setNombre(nombre);
		return this;
	}

}
