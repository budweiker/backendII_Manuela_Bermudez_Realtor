
package com.Cesde.manuelaBermudezRealtor.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "seller")
@PrimaryKeyJoinColumn(name = "user_id")
public class MSeller extends MUser {
    @Column(nullable = false)
    private int propiedadesVendidas;

    @Column(precision = 14, scale = 2, nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    public int getPropiedadesVendidas() { return propiedadesVendidas; }
    public void setPropiedadesVendidas(int propiedadesVendidas) {
        this.propiedadesVendidas = propiedadesVendidas;
    }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
