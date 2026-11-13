package com.Cesde.manuelaBermudezRealtor.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContractDTO {
	private Integer id;
	private Integer propiedadId;
	private Integer vendedorId;
	private Integer compradorId;
	private LocalDate fechaContrato;
	private BigDecimal valorVenta;
	private String estado;

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public Integer getPropiedadId() { return propiedadId; }
	public void setPropiedadId(Integer propiedadId) { this.propiedadId = propiedadId; }
	public Integer getVendedorId() { return vendedorId; }
	public void setVendedorId(Integer vendedorId) { this.vendedorId = vendedorId; }
	public Integer getCompradorId() { return compradorId; }
	public void setCompradorId(Integer compradorId) { this.compradorId = compradorId; }
	public LocalDate getFechaContrato() { return fechaContrato; }
	public void setFechaContrato(LocalDate fechaContrato) { this.fechaContrato = fechaContrato; }
	public BigDecimal getValorVenta() { return valorVenta; }
	public void setValorVenta(BigDecimal valorVenta) { this.valorVenta = valorVenta; }
	public String getEstado() { return estado; }
	public void setEstado(String estado) { this.estado = estado; }
}
