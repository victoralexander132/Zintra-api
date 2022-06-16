package com.generation.zintra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "carrito")
public @Data class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "carrito_id")
    private Integer id;

    //Recibe cliente_id
    @ManyToOne
    @JoinColumn(nullable = false, name = "usuario_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Usuario usuario;

    //Se manda carrito_id a envío
    @OneToOne(mappedBy = "carrito", cascade = CascadeType.REMOVE)
    private Envio envio;

    // Se manda carrito_id a carritoProductos
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.REMOVE)
    private List<CarritoProducto> carritoProductos;

}

