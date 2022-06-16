package com.generation.zintra.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
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
    private List<Carrito> carrito;

    /*Getters & Setters*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Carrito> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Carrito> carrito) {
        this.carrito = carrito;
    }
}
