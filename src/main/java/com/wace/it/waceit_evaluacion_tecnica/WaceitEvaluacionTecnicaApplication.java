package com.wace.it.waceit_evaluacion_tecnica;

import com.wace.it.waceit_evaluacion_tecnica.bussiness.services.EstudianteService;
import com.wace.it.waceit_evaluacion_tecnica.bussiness.services.RolService;
import com.wace.it.waceit_evaluacion_tecnica.bussiness.services.UsuarioRolService;
import com.wace.it.waceit_evaluacion_tecnica.bussiness.services.builder.EstudianteBuilder;
import com.wace.it.waceit_evaluacion_tecnica.bussiness.services.builder.RolBuilder;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.Estudiante;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.Rol;
import com.wace.it.waceit_evaluacion_tecnica.data.entities.UsuarioRol;
import com.wace.it.waceit_evaluacion_tecnica.data.enums.RolEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.server.ResponseStatusException;

@SpringBootApplication
public class WaceitEvaluacionTecnicaApplication implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(WaceitEvaluacionTecnicaApplication.class);
    private static final String ADMIIN_USER = "Administrador";

    public static void main(String[] args) {
        SpringApplication.run(WaceitEvaluacionTecnicaApplication.class, args);
    }


    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private RolService rolService;

    @Autowired
    private UsuarioRolService usuarioRolService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            estudianteService.getEstudiantePorNombreYApellido(ADMIIN_USER, ADMIIN_USER);
        } catch (final ResponseStatusException e) {
            crearDatosIniciales();
        }

    }

    private void crearDatosIniciales() {
        // Permite crear datos de prueba
    }
}
