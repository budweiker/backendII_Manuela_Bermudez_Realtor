package com.Cesde.manuelaBermudezRealtor.modelo;
import jakarta.persistence.*;

@Entity
@Table(name="buyer")
public class MBuyer {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(length = 70, nullable = false)
    private String nomComprador;
    @Column(length = 15, nullable = false)
    private String password;
    @Column(length = 10, nullable = false)
    private String telComprador;
    @Column(length = 50, nullable = false)
    private String correoComprador;
    @Column(length = 2, nullable = false)
    private boolean status;

    public Integer getIdCliente() {
        return idCliente;
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

    public String getTelComprador() {
        return telComprador;
    }

    public void setTelComprador(String telComprador) {
        this.telComprador = telComprador;
    }

    public String getCorreoComprador() {
        return correoComprador;
    }

    public void setCorreoComprador(String correoComprador) {
        this.correoComprador = correoComprador;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
