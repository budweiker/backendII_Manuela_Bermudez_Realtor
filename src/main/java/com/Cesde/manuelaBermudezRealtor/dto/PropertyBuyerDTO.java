package com.Cesde.manuelaBermudezRealtor.dto;

import java.time.LocalDate;

public class PropertyBuyerDTO {
    private Integer id;
    private Integer propiedadId;
    private Integer compradorId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getPropiedadId() { return propiedadId; }
    public void setPropiedadId(Integer propiedadId) { this.propiedadId = propiedadId; }
    public Integer getCompradorId() { return compradorId; }
    public void setCompradorId(Integer compradorId) { this.compradorId = compradorId; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}
