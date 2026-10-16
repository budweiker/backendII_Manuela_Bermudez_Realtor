package com.Cesde.manuelaBermudezRealtor.modelo;
import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name="seller")
public class MSeller {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(length = 70, nullable = false)
    private String nomvendedor;
    @Column(length = 15, nullable = false)
    private String password;
    @Column(length = 10, nullable = false)
    private String telVendedor;
    @Column(length = 50, nullable = false)
    private String correoVendedor;
    @Column(length = 2, nullable = false)
    private boolean status;
    @Column(length = 10, nullable = true)
    private int propiedadesVendidas;
    @Column(length=20, nullable = false)
    private BigDecimal balance;
    
}
