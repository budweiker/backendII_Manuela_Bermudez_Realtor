package com.Cesde.manuelaBermudezRealtor.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "contract")
public class MContract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "propiedad_id", nullable = false)
	private MProperty propiedad;

	@ManyToOne(optional = false)
	@JoinColumn(name = "vendedor_id", nullable = false)
	private MSeller vendedor;

	@ManyToOne(optional = false)
	@JoinColumn(name = "comprador_id", nullable = false)
	private MBuyer comprador;

	private LocalDate fechaContrato;

	@Column(precision = 14, scale = 2, nullable = false)
	private BigDecimal valorVenta;

	@Column(length = 30, nullable = false)
	private String estado;

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	public MProperty getPropiedad() { return propiedad; }
	public void setPropiedad(MProperty propiedad) { this.propiedad = propiedad; }
	public MSeller getVendedor() { return vendedor; }
	public void setVendedor(MSeller vendedor) { this.vendedor = vendedor; }
	public MBuyer getComprador() { return comprador; }
	public void setComprador(MBuyer comprador) { this.comprador = comprador; }
	public LocalDate getFechaContrato() { return fechaContrato; }
	public void setFechaContrato(LocalDate fechaContrato) { this.fechaContrato = fechaContrato; }
	public BigDecimal getValorVenta() { return valorVenta; }
	public void setValorVenta(BigDecimal valorVenta) { this.valorVenta = valorVenta; }
	public String getEstado() { return estado; }
	public void setEstado(String estado) { this.estado = estado; }
}
