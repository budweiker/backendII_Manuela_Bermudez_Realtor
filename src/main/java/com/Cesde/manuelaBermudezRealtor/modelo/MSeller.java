package com.Cesde.manuelaBermudezRealtor.modelo;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "seller")
@PrimaryKeyJoinColumn(name = "user_id")
public class MSeller extends MUser {

    @Column(nullable = false)
    private int propiedadesVendidas;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal balance;

    @OneToMany(mappedBy = "vendedor")
    @JsonManagedReference
    private List<MPropertySeller> propiedades;

    public MSeller() {}

    public int getPropiedadesVendidas() { return propiedadesVendidas; }
    public void setPropiedadesVendidas(int propiedadesVendidas) {
        this.propiedadesVendidas = propiedadesVendidas;
    }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    public List<MPropertySeller> getPropiedades() { return propiedades; }
    public void setPropiedades(List<MPropertySeller> propiedades) { this.propiedades = propiedades; }
}