package com.Cesde.manuelaBermudezRealtor.modelo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="buyer")
public class MBuyer {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComprador;
    @Column(length = 70, nullable = false)
    private String nomComprador;
    @Column(length = 15, nullable = false)
    private String password;
    @Column(length = 60, nullable = false)
    private String telComprador;
    @Column(length = 50, nullable = false)
    private String correoComprador;
    @Column(nullable = false)
    private boolean status;

    //Relaciones entre comprador y propiedad
    @OneToMany(mappedBy = "comprador")
    @JsonManagedReference
    private List<MpropiedadComprador> propiedades;

    //Encapsulamiento


    public String getCorreoComprador() {
        return correoComprador;
    }

    public void setCorreoComprador(String correoComprador) {
        this.correoComprador = correoComprador;
    }

    public Integer getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(Integer idComprador) {
        this.idComprador = idComprador;
    }

    public String getNomComprador() {
        return nomComprador;
    }

    public void setNomComprador(String nomComprador) {
        this.nomComprador = nomComprador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<MpropiedadComprador> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<MpropiedadComprador> propiedades) {
        this.propiedades = propiedades;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTelComprador() {
        return telComprador;
    }

    public void setTelComprador(String telComprador) {
        this.telComprador = telComprador;
    }
}
