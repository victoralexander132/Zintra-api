package com.generation.zintra.service;

import com.generation.zintra.model.Usuario;

import java.util.List;

public interface UsuarioService {
    // Leer
    Usuario getUsuario(Integer id);

    List<Usuario> getUsuarios();

    // Guardar
    Usuario saveUsuario(Usuario usuario);

    // Borrar
    Boolean deleteUsuario(Integer id);

    // Actualizar
    Usuario updateUsuario(Usuario usuario);

    // Login
//    boolean verificarLogin(String email, String contrasenia);

}
