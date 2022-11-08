package com.wace.it.waceit_evaluacion_tecnica.security;

import com.wace.it.waceit_evaluacion_tecnica.data.enums.AuthoritiesEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringConfiguration implements WebMvcConfigurer {


	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().headers().frameOptions().disable().and()
				.authorizeRequests()
				// Configurar el acceso libre a la consola de h2
				.antMatchers("/h2-console/**").permitAll()
				// Configurar el acceso al api rest para obtener estudiantes
				.antMatchers(HttpMethod.GET, "/estudiantes/{cedula}")
				.hasAnyAuthority(AuthoritiesEnum.ROLE_ADMINISTRADOR.name(), AuthoritiesEnum.ROLE_ESTUDIANTE.name())
				// Configurar el acceso a la actualizaci[on del estudiante que lo puede hacer el
				// admin o el estudiante
				.antMatchers(HttpMethod.POST, "/estudiantes/{cedula}")
				.hasAnyAuthority(AuthoritiesEnum.ROLE_ADMINISTRADOR.name(), AuthoritiesEnum.ROLE_ESTUDIANTE.name())
				// Configurar el acceso al api rest para obtener el username de un estudiante
				.antMatchers(HttpMethod.GET, "/usuarios/username/{cedula}")
				.hasAnyAuthority(AuthoritiesEnum.ROLE_ADMINISTRADOR.name(), AuthoritiesEnum.ROLE_ESTUDIANTE.name())
				// Configurar el acceso al api rest
				.antMatchers("/estudiantes/**").hasAuthority(AuthoritiesEnum.ROLE_ADMINISTRADOR.name())

				// El resto de solicitudes debe estar autenticadas
				.anyRequest().authenticated().and().httpBasic();

		return http.build();
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}
}
