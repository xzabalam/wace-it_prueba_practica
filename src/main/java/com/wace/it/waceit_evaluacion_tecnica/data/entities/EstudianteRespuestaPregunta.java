package com.wace.it.waceit_evaluacion_tecnica.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "estudiante_respuesta_pregunta")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteRespuestaPregunta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "pregunta_id", referencedColumnName = "id")
    private Pregunta pregunta;

    @NotNull
    @Column(name = "fecha_responde", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonIgnore
    private Date fechaResponde;

    @NotNull
    @Column(name = "respuesta_pregunta")
    private Boolean respuestaPregunta;
}
