package com.generation.zintra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import javax.persistence.*;


@Entity
@Table(name = "envio") //homologar nombres de las diferentes tablas

public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "envio_id")
    private Integer id;

    @Column(nullable = false, name = "nombre_cliente")
    private String nombre;
    @Column(nullable = false, name = "apellido_cliente")
    private String apellido;
    @Column(nullable = false, name = "telefono")
    private String telefono;
    @Column(nullable = false, name = "email")
    private String email;
    @Column(nullable = false, name = "estado")
    private String estado;
    @Column(nullable = false, name = "ciudad")
    private String ciudad;
    @Column(nullable = false, name = "cp")
    private Integer cp;
    @Column(nullable = false, name = "direccion")
    private String direccion;
    @Column(nullable = false, name = "referencias")
    private String referencias;

    // Llave foránea
    @OneToOne
    @JoinColumn(nullable = false, name = "carrito_id")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Carrito carrito;

    @OneToOne(mappedBy = "envio", cascade = CascadeType.REMOVE)
    private Pago pago;

    /*Getters & Setters*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}
