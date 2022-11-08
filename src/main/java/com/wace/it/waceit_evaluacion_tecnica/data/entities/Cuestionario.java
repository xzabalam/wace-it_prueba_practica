package com.wace.it.waceit_evaluacion_tecnica.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cuestionario")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cuestionario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonIgnore
    private Date fechaCreacion;

    @NotEmpty
    @Column(name = "nombre", nullable = false)
    @JsonIgnore
    private String nombre;
}
