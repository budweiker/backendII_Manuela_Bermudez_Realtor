package com.Cesde.manuelaBermudezRealtor.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="propiedadComprador")
public class MpropertyBuyer {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpropiedadcomprador;

    @ManyToOne
    @JoinColumn(name = "comprador_id", nullable = false)

    @JoinColumn(name="propiedad_id", nullable = false)
    private MProperty propiedad;

    @JsonBackReference
    private MBuyer comprador;

    //constructores

    public MpropertyBuyer(MBuyer comprador, Integer idpropiedadcomprador) {
        this.comprador = comprador;
        this.idpropiedadcomprador = idpropiedadcomprador;
    }

    //Encapsulamiento


    public MBuyer getComprador() {
        return comprador;
    }

    public void setComprador(MBuyer comprador) {
        this.comprador = comprador;
    }

    public Integer getIdpropiedadcomprador() {
        return idpropiedadcomprador;
    }

    public void setIdpropiedadcomprador(Integer idpropiedadcomprador) {
        this.idpropiedadcomprador = idpropiedadcomprador;
    }
}
