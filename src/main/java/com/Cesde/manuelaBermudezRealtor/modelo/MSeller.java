
package com.Cesde.manuelaBermudezRealtor.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "seller")
public class MSeller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVendedor;

    @Column(length = 70, nullable = false)
    private String nomVendedor;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String telVendedor;

    @Column(length = 50, nullable = false)
    private String correoVendedor;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private int propiedadesVendidas;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal balance;

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNomVendedor() {
        return nomVendedor;
    }

    public void setNomVendedor(String nomVendedor) {
        this.nomVendedor = nomVendedor;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelVendedor() {
        return telVendedor;
    }

    public void setTelVendedor(String telVendedor) {
        this.telVendedor = telVendedor;
    }

    public String getCorreoVendedor() {
        return correoVendedor;
    }

    public void setCorreoVendedor(String correoVendedor) {
        this.correoVendedor = correoVendedor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getPropiedadesVendidas() {
        return propiedadesVendidas;
    }

    public void setPropiedadesVendidas(int propiedadesVendidas) {
        this.propiedadesVendidas = propiedadesVendidas;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
