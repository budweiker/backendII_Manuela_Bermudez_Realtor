package com.Cesde.manuelaBermudezRealtor.modelo;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
=======
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
>>>>>>> b4363b2ea7a4a7a01fc95000223fa1bff0dbef61

import java.math.BigDecimal;

@Entity
@Table(name = "seller")
@PrimaryKeyJoinColumn(name = "user_id")
public class MSeller extends MUser {
<<<<<<< HEAD
    @Column(nullable = false)
    private int propiedadesVendidas;

    @Column(precision = 14, scale = 2, nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;
=======

    @Column(nullable = false)
    private int propiedadesVendidas;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal balance;

    @OneToMany(mappedBy = "vendedor")
    @JsonManagedReference
    private List<MPropertySeller> propiedades;

    public MSeller() {}
>>>>>>> b4363b2ea7a4a7a01fc95000223fa1bff0dbef61

    public int getPropiedadesVendidas() { return propiedadesVendidas; }
    public void setPropiedadesVendidas(int propiedadesVendidas) {
        this.propiedadesVendidas = propiedadesVendidas;
    }
<<<<<<< HEAD
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
=======

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

    public List<MPropertySeller> getPropiedades() { return propiedades; }
    public void setPropiedades(List<MPropertySeller> propiedades) { this.propiedades = propiedades; }
}
>>>>>>> b4363b2ea7a4a7a01fc95000223fa1bff0dbef61
