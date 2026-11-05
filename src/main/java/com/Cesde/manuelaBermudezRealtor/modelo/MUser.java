package com.Cesde.manuelaBermudezRealtor.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public class MUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido;

    @Column(length = 10, nullable = false)
    private String telefono;

    @Column(length = 50, nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private boolean status;

    public MUser() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}