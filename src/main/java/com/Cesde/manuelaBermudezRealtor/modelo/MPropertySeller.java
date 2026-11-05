package com.Cesde.manuelaBermudezRealtor.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "propiedadVendedor")
public class MPropertySeller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpropiedadvendedor;

    @ManyToOne
    @JoinColumn(name = "propiedad_id", nullable = false)
    private MProperty propiedad;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    @JsonBackReference
    private MSeller vendedor;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    public MPropertySeller() {}

    public MPropertySeller(MProperty propiedad, MSeller vendedor, LocalDate fechaInicio, LocalDate fechaFin) {
        this.propiedad = propiedad;
        this.vendedor = vendedor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdpropiedadvendedor() { return idpropiedadvendedor; }
    public void setIdpropiedadvendedor(Integer idpropiedadvendedor) { this.idpropiedadvendedor = idpropiedadvendedor; }

    public MProperty getPropiedad() { return propiedad; }
    public void setPropiedad(MProperty propiedad) { this.propiedad = propiedad; }

    public MSeller getVendedor() { return vendedor; }
    public void setVendedor(MSeller vendedor) { this.vendedor = vendedor; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}