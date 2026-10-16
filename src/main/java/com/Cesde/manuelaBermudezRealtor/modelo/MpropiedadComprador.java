package com.Cesde.manuelaBermudezRealtor.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="propiedadComprador")
public class MpropiedadComprador {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpropiedadcomprador;
    @ManyToOne
    @JoinColumn(name = "comprador_id", nullable = false)
    @JsonBackReference
    private MBuyer comprador;
}
