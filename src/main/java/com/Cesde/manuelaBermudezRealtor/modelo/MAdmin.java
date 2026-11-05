package com.Cesde.manuelaBermudezRealtor.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "user_id")
public class MAdmin extends MUser {

    @Column(length = 30, nullable = false)
    private String adminType;

    public MAdmin() {}

    public String getAdminType() { return adminType; }
    public void setAdminType(String adminType) { this.adminType = adminType; }
}