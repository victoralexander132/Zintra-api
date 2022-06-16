package com.generation.zintra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
public @Data class Producto {

    /*============================================================*/

    //    Llave primaria - auto incrementada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name="producto_id")
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Integer precio;

    @Column(nullable = false)
    private String tamanio;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String uso;

    @Column(nullable = false)
    private String url;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.REMOVE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<CarritoProducto> carritoProducto;

}
