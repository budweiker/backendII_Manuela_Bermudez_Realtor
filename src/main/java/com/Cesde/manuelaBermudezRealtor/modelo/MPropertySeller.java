package com.Cesde.manuelaBermudezRealtor.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "property_seller")
public class MPropertySeller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "propiedad_id", nullable = false)
	private MProperty propiedad;

	@ManyToOne(optional = false)
	@JoinColumn(name = "vendedor_id", nullable = false)
	private MSeller vendedor;

	private LocalDate fechaInicio;
	private LocalDate fechaFin;

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public MProperty getPropiedad() { return propiedad; }
	public void setPropiedad(MProperty propiedad) { this.propiedad = propiedad; }
	public MSeller getVendedor() { return vendedor; }
	public void setVendedor(MSeller vendedor) { this.vendedor = vendedor; }
	public LocalDate getFechaInicio() { return fechaInicio; }
	public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
	public LocalDate getFechaFin() { return fechaFin; }
	public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
}
