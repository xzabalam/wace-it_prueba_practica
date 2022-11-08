package com.wace.it.waceit_evaluacion_tecnica.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "asigna_cuestionario")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AsignaCuestionario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "fecha_asignacion", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonIgnore
    private Date fechaAsignacion;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id")
    private Estudiante estudiante;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cuestionario_id", referencedColumnName = "id")
    private Cuestionario cuestionario;
}
