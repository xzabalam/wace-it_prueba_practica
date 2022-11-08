package com.wace.it.waceit_evaluacion_tecnica.bussiness.services.builder;

import java.util.Calendar;
import java.util.Date;

import com.wace.it.waceit_evaluacion_tecnica.data.entities.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioBuilder {

	public static final String getEncode(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}

	public static final UsuarioBuilder newBuilder() {
		return new UsuarioBuilder();
	}

	private String nombres = "";
	private String apellidos = "";


	public UsuarioBuilder apellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	}

	public Usuario build() {
		final String username = generateUsername();
		final String password = getEncode(username);

		return new Usuario(username, password);
	}

	public UsuarioBuilder nombres(String nombres) {
		this.nombres = nombres;
		return this;
	}


	private String generatarFecha() {
		final Calendar calendar = Calendar.getInstance();
		final Integer dia = calendar.get(Calendar.DAY_OF_MONTH);
		final Integer mes = calendar.get(Calendar.MONTH);
		final Integer anio = calendar.get(Calendar.YEAR);

		return String.format("%d%d%d", dia, mes, anio);
	}

	private String generateUsername() {
		final String primeraParteDelUsername = getFirstLetter(nombres);
		final String segundaParteDelUsername = getFirstLetter(apellidos);
		final String fecha = generatarFecha();
		return String.format("%s%s%s", primeraParteDelUsername, segundaParteDelUsername, fecha);
	}

	private String getFirstLetter(String nombres) {
		final String[] arrayItems = nombres.trim().toLowerCase().split(" ");
		final StringBuilder firstLetters = new StringBuilder();
		for (final String item : arrayItems) {
			firstLetters.append(item.substring(0, 1));
		}
		return firstLetters.toString();
	}
}
