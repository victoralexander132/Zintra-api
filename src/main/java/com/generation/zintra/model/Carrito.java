package com.generation.zintra.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Carrito")
public @Data class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "carrito_id")
    private Integer carrito_id;

    //Recibe cliente_id
    @OneToOne
    @JoinColumn(nullable = false, name = "usuario_id")
    private Usuario usuario;

    //Se manda carrito_id a envío
    @OneToOne(mappedBy = "carrito_id", cascade = CascadeType.REMOVE)
    private Envio envio;

    // Se manda carrito_id a carritoProductos
    @OneToMany(mappedBy = "carrito_id", cascade = CascadeType.REMOVE)
    private List<CarritoProducto> carritoProductos;


//    // Recibe carritoproducto_id
//    @OneToMany(mappedBy = "Carrito", cascade = CascadeType.REMOVE)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private List<CarritoProducto> carritoProducto;



}

