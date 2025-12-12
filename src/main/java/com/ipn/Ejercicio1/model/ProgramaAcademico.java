package com.ipn.Ejercicio1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "programaacademico")
public class ProgramaAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPE;

    @Column(nullable = false, length = 200)
    private String nombrePE;

    @Column(nullable = false, length = 100)
    private String descripcion;

    // Getters y Setters
    public Integer getIdPE() { return idPE; }
    public void setIdPE(Integer idPE) { this.idPE = idPE; }

    public String getNombrePE() { return nombrePE; }
    public void setNombrePE(String nombrePE) { this.nombrePE = nombrePE; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
