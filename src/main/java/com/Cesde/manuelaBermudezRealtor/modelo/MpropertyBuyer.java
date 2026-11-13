package com.Cesde.manuelaBermudezRealtor.modelo;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "property_buyer")
public class MpropertyBuyer {
=======
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "propiedadComprador")
public class MpropertyBuyer {

>>>>>>> b4363b2ea7a4a7a01fc95000223fa1bff0dbef61
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

<<<<<<< HEAD
    @ManyToOne(optional = false)
    @JoinColumn(name = "propiedad_id", nullable = false)
=======
    @ManyToOne
    @JoinColumn(name = "propiedad_id", nullable = false)
    private MProperty propiedad;

    @JoinColumn(name="propiedad_id", nullable = false)
>>>>>>> b4363b2ea7a4a7a01fc95000223fa1bff0dbef61
    private MProperty propiedad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "comprador_id", nullable = false)
    private MBuyer comprador;

<<<<<<< HEAD
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public MProperty getPropiedad() { return propiedad; }
    public void setPropiedad(MProperty propiedad) { this.propiedad = propiedad; }
    public MBuyer getComprador() { return comprador; }
    public void setComprador(MBuyer comprador) { this.comprador = comprador; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}
=======
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
>>>>>>> b4363b2ea7a4a7a01fc95000223fa1bff0dbef61
