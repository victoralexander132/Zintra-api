package com.generation.zintra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "compraCarrito")
public @Data class CompraCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "compra_id")
    private Integer compra_id;

    //Recibe cliente_id
    @OneToOne
    @JoinColumn(nullable = false, name = "usuario_id")
    private Usuario usuario;

    //Se envia carrito_id a direccion
    @OneToOne(mappedBy = "compraCarrito", cascade = CascadeType.REMOVE)
    private Envio envio;

    // Se envía carrito id
    @OneToMany(mappedBy = "compraCarrito", cascade = CascadeType.REMOVE)
    private List<CarritoProducto> carritoProductos;


    // Recibe carritoproducto_id
    @OneToMany(mappedBy = "compraCarrito", cascade = CascadeType.REMOVE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<CarritoProducto> carritoProducto;



}

