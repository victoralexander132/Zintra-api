package com.generation.zintra.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CarritoProducto")
public @Data class CarritoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "carritoproducto_id")
    private Integer carritoproducto_id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "producto_id")
    private Producto producto_id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "carrito_id")
    private Carrito carrito_id;

    @Column(nullable = false, name = "cant_productos")
    private Integer cant_productos;

    @Column(nullable = false, name = "precio")
    private Float precio;
}
