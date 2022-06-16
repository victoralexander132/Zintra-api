package com.generation.zintra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public @Data class Usuario {
    /*============================================================*/

    //    Llave primaria - auto incrementada
    @Id
    @Column(name="usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuario_id;

    // Columna de nombre
    @Column(nullable = false)
    private String nombre;
    // Columna de teléfono
    @Column(nullable = false)
    private String telefono;

    //  Columna de correo
    @Column(nullable = false, unique = true)
    private String email;

    //  Columna de contraseña
    @Column(nullable = false)
    private String contrasenia;

    @OneToOne(mappedBy = "usuario")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CompraCarrito compraCarrito;


}