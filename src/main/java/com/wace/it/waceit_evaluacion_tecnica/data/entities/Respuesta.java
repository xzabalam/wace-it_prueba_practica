package com.wace.it.waceit_evaluacion_tecnica.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "respuestas")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Respuesta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nombre_respuesta", nullable = false)
    @JsonIgnore
    private String nombreRespuesta;

    /**
     * Permite saber si la respuesta es la correcta o no
     */
    @NotNull
    @Column(name = "es_respuesta_correcta")
    private Boolean esRespuestaCorrecta;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "pregunta_id", referencedColumnName = "id")
    private Pregunta pregunta;
}
