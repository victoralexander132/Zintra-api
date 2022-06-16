package com.generation.zintra.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public @Data class Usuario {
    /*============================================================*/

    //    Llave primaria - auto incrementada
    @Id
    @Column(nullable = false, name="usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Carrito> carrito;


}
