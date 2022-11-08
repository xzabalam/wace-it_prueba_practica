-- usuarios
insert into "usuario"( "username", "password") values( 'admin', 'admin');
insert into "usuario"( "username", "password") values( 'empleado1', 'empleado1');
insert into "usuario"( "username", "password") values( 'empleado2', 'empleado2');

-- roles
insert into "rol"("descripcion","nombre") values( 'ADMINISTRADOR', 'ADMINISTRADOR');
insert into "rol"("descripcion","nombre") values( 'ESTUDIANTE', 'ESTUDIANTE');

-- usuario_rol
insert into "usuario_rol" ( "usuario_id", "rol_id") values( 1, 1);
insert into "usuario_rol" ( "usuario_id", "rol_id") values( 2, 2);
insert into "usuario_rol" ( "usuario_id", "rol_id") values( 3, 2);

-- estudiante
insert into "estudiante"("cedula","nombres","apellidos","user_id") values( '0102030400', 'nombre 1',
                                                                               'apellidos 1', '1');
insert into "estudiante"("cedula","nombres","apellidos","user_id") values( '0102030401', 'nombre 2',
                                                                               'apellidos 2', '2');
insert into "estudiante"("cedula","nombres","apellidos","user_id") values( '0102030402', 'nombre 3',
                                                                               'apellidos 3', '3');

-- cuestionario
insert into "cuestionario" ("nombre","fecha_creacion") values( 'cuestionario 1', CURRENT_TIMESTAMP());

-- preguntas
insert into "preguntas"("nombre_pregunta", "cuestionario_id") values('pregunta 1', 1);
insert into "preguntas"("nombre_pregunta", "cuestionario_id") values('pregunta 2', 1);
insert into "preguntas"("nombre_pregunta", "cuestionario_id") values('pregunta 3', 1);
insert into "preguntas"("nombre_pregunta", "cuestionario_id") values('pregunta 4', 1);
insert into "preguntas"("nombre_pregunta", "cuestionario_id") values('pregunta 5', 1);
insert into "preguntas"("nombre_pregunta", "cuestionario_id") values('pregunta 6', 1);

-- respuestas pregunta 1
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion a', 1, 1);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion b', 0, 1);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion c', 0, 1);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion d', 0, 1);

-- respuestas pregunta 2
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion a', 0, 2);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion b', 1, 2);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion c', 0, 2);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion d', 0, 2);

-- respuestas pregunta 3
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion a', 0, 3);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion b', 0, 3);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion c', 1, 3);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion d', 0, 3);

-- respuestas pregunta 4
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion a', 0, 4);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion b', 0, 4);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion c', 0, 4);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion d', 1, 4);

-- respuestas pregunta 5
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion a', 1, 5);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion b', 1, 5);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion c', 1, 5);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion d', 0, 5);

-- respuestas pregunta 6
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion a', 1, 6);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion b', 0, 6);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion c', 1, 6);
insert into "respuestas"("nombre_respuesta", "es_respuesta_correcta", "pregunta_id") values('opcion d', 0, 6);

-- asigna_cuestionario
insert into "asigna_cuestionario"("fecha_asignacion", "cuestionario_id", "estudiante_id") values(CURRENT_TIMESTAMP(),
                                                                                                 1, 2);
insert into "asigna_cuestionario"("fecha_asignacion", "cuestionario_id", "estudiante_id") values(CURRENT_TIMESTAMP(),
                                                                                                 1, 3);
-- estudiante_respuesta_pregunta
insert into "estudiante_respuesta_pregunta"("fecha_responde", "respuesta_pregunta", "estudiante_id", "pregunta_id")
    values(CURRENT_TIMESTAMP(),1, 1, 1);
insert into "estudiante_respuesta_pregunta"("fecha_responde", "respuesta_pregunta", "estudiante_id", "pregunta_id")
values(CURRENT_TIMESTAMP(),0, 1, 2);
insert into "estudiante_respuesta_pregunta"("fecha_responde", "respuesta_pregunta", "estudiante_id", "pregunta_id")
values(CURRENT_TIMESTAMP(),1, 1, 3);