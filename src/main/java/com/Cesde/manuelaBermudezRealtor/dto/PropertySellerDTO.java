package com.Cesde.manuelaBermudezRealtor.dto;

import java.time.LocalDate;

public class PropertySellerDTO {
	private Integer id;
	private Integer propiedadId;
	private Integer vendedorId;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public Integer getPropiedadId() { return propiedadId; }
	public void setPropiedadId(Integer propiedadId) { this.propiedadId = propiedadId; }
	public Integer getVendedorId() { return vendedorId; }
	public void setVendedorId(Integer vendedorId) { this.vendedorId = vendedorId; }
	public LocalDate getFechaInicio() { return fechaInicio; }
	public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
	public LocalDate getFechaFin() { return fechaFin; }
	public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}
