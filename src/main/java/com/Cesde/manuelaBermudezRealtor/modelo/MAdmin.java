package com.Cesde.manuelaBermudezRealtor.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "user_id")
public class MAdmin extends MUser {
	@Column(length = 50, nullable = false)
	private String adminType;

	public String getAdminType() { return adminType; }
	public void setAdminType(String adminType) { this.adminType = adminType; }
}
