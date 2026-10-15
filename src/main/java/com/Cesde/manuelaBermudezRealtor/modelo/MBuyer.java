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
    


}
