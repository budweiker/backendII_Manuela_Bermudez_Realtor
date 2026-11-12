package com.Cesde.manuelaBermudezRealtor.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "property")
public class MProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPropiedad;

    @Column(nullable = false)
    private float propiedadValor;

    @Column(length = 100, nullable = false)
    private String ubicacionPropiedad;

    @Column(length = 100, nullable = false)
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

    public Integer getIdPropiedad() { return idPropiedad; }
    public void setIdPropiedad(Integer idPropiedad) { this.idPropiedad = idPropiedad; }
    public float getPropiedadValor() { return propiedadValor; }
    public void setPropiedadValor(float propiedadValor) { this.propiedadValor = propiedadValor; }
    public String getUbicacionPropiedad() { return ubicacionPropiedad; }
    public void setUbicacionPropiedad(String ubicacionPropiedad) { this.ubicacionPropiedad = ubicacionPropiedad; }
    public String getPropiedadDireccion() { return propiedadDireccion; }
    public void setPropiedadDireccion(String propiedadDireccion) { this.propiedadDireccion = propiedadDireccion; }
    public int getHabitaciones() { return habitaciones; }
    public void setHabitaciones(int habitaciones) { this.habitaciones = habitaciones; }
    public int getBanos() { return banos; }
    public void setBanos(int banos) { this.banos = banos; }
    public int getArea() { return area; }
    public void setArea(int area) { this.area = area; }
    public int getEstrato() { return estrato; }
    public void setEstrato(int estrato) { this.estrato = estrato; }
    public String getBarrio() { return barrio; }
    public void setBarrio(String barrio) { this.barrio = barrio; }
    public String getMunicipio() { return municipio; }
    public void setMunicipio(String municipio) { this.municipio = municipio; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
