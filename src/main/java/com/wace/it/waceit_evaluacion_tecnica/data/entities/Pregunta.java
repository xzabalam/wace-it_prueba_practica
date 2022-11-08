package com.wace.it.waceit_evaluacion_tecnica.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "preguntas")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pregunta {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nombre_pregunta", nullable = false)
    @JsonIgnore
    private String nombrePregunta;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cuestionario_id", referencedColumnName = "id")
    private Cuestionario cuestionario;
}
