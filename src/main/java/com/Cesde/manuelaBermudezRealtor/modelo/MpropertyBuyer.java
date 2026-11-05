package com.Cesde.manuelaBermudezRealtor.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "propiedadComprador")
public class MpropertyBuyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpropiedadcomprador;

    @ManyToOne
    @JoinColumn(name = "propiedad_id", nullable = false)
    private MProperty propiedad;

    @JoinColumn(name="propiedad_id", nullable = false)
    private MProperty propiedad;

    @JsonBackReference
    private MBuyer comprador;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    public MpropertyBuyer() {}

    public MpropertyBuyer(MProperty propiedad, MBuyer comprador, LocalDate fechaInicio, LocalDate fechaFin) {
        this.propiedad = propiedad;
        this.comprador = comprador;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdpropiedadcomprador() { return idpropiedadcomprador; }
    public void setIdpropiedadcomprador(Integer idpropiedadcomprador) { this.idpropiedadcomprador = idpropiedadcomprador; }

    public MProperty getPropiedad() { return propiedad; }
    public void setPropiedad(MProperty propiedad) { this.propiedad = propiedad; }

    public MBuyer getComprador() { return comprador; }
    public void setComprador(MBuyer comprador) { this.comprador = comprador; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}