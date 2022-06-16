package com.generation.zintra.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "carritoproducto")
public @Data class CarritoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "carritoproducto_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(nullable = false, name = "carrito_id")
    private Carrito carrito;

    @Column(nullable = false, name = "cant_productos")
    private Integer cant_productos;

    @Column(nullable = false, name = "precio")
    private Float precio;
}
