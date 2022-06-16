package com.generation.zintra.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "carritoproducto")
public class CarritoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "carritoproducto_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(nullable = false, name = "carrito_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Carrito carrito;

    @Column(nullable = false, name = "cant_productos")
    private Integer cant_productos;

    @Column(nullable = false, name = "precio")
    private Float precio;

    /*Getters & Setters*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Integer getCant_productos() {
        return cant_productos;
    }

    public void setCant_productos(Integer cant_productos) {
        this.cant_productos = cant_productos;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
