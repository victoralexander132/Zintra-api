package com.generation.zintra.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "carrito")
public class Carrito {

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

    /*Getters & Setters*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    public List<CarritoProducto> getCarritoProductos() {
        return carritoProductos;
    }

    public void setCarritoProductos(List<CarritoProducto> carritoProductos) {
        this.carritoProductos = carritoProductos;
    }
}

