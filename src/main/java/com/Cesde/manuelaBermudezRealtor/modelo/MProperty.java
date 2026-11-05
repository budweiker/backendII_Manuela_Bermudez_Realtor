package com.Cesde.manuelaBermudezRealtor.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name="property")
public class MProperty {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropiedad;

    @Column(nullable = false)
    private float propiedadValor;

    @Column(length = 70, nullable = false)
    private String propiedadDireccion;

    @Column(nullable = false)
    private int habitaciones;

    @Column(nullable = false)
    private int banos;

    @Column(nullable = false)
    private int area;

    @Column(nullable = false)
    private int estrato;

    @Column(length = 50, nullable = false)
    private String barrio;

    @Column(length = 50, nullable = false)
    private String municipio;

    @Column(length = 50, nullable = false)
    private String estado;

    //Relaciones entre tablas
    @OneToMany(mappedBy = "propiedad")
    private List<MpropertyBuyer> compradores;

    //Encapsulamiento
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Integer idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getPropiedadDireccion() {
        return propiedadDireccion;
    }

    public void setPropiedadDireccion(String propiedadDireccion) {
        this.propiedadDireccion = propiedadDireccion;
    }

    public float getPropiedadValor() {
        return propiedadValor;
    }

    public void setPropiedadValor(float propiedadValor) {
        this.propiedadValor = propiedadValor;
    }
}
