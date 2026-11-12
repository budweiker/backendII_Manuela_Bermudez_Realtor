package com.Cesde.manuelaBermudezRealtor.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "buyer")
@PrimaryKeyJoinColumn(name = "user_id")
public class MBuyer extends MUser {
    @Column(length = 255)
    private String propiedadDeInteresActual;

    @Column(precision = 14, scale = 2, nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    public String getPropiedadDeInteresActual() { return propiedadDeInteresActual; }
    public void setPropiedadDeInteresActual(String propiedadDeInteresActual) {
        this.propiedadDeInteresActual = propiedadDeInteresActual;
    }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
