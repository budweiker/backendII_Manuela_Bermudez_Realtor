package com.Cesde.manuelaBermudezRealtor.modelo;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
=======
import jakarta.persistence.*;
>>>>>>> b4363b2ea7a4a7a01fc95000223fa1bff0dbef61

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "user_id")
public class MAdmin extends MUser {
<<<<<<< HEAD
	@Column(length = 50, nullable = false)
	private String adminType;

	public String getAdminType() { return adminType; }
	public void setAdminType(String adminType) { this.adminType = adminType; }
}
=======

    @Column(length = 30, nullable = false)
    private String adminType;

    public MAdmin() {}

    public String getAdminType() { return adminType; }
    public void setAdminType(String adminType) { this.adminType = adminType; }
}
>>>>>>> b4363b2ea7a4a7a01fc95000223fa1bff0dbef61
