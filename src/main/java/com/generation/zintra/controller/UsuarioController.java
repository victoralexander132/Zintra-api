package com.generation.zintra.controller;

import com.generation.zintra.model.Usuario;
import com.generation.zintra.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/Usuario")
public class UsuarioController {

    private final UsuarioService usuarioService; // Inyección de Service

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UsuarioController(@Autowired UsuarioService usuarioService, @Autowired BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioService = usuarioService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // Leer
    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Integer id) {
        return usuarioService.getUsuario(id);
    }

    @GetMapping("/all")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    // Escribir
    @PostMapping
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        // Encriptando contraseña
        usuario.setContrasenia(bCryptPasswordEncoder.encode(usuario.getContrasenia()));
        // Guardando registro en bd
        return usuarioService.saveUsuario(usuario);
    }

    // Borrar
    @DeleteMapping("delete/{id}")
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
    }

    // Actualizar
    @PutMapping
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return usuarioService.updateUsuario(usuario);
    }

    // Login
//  @PostMapping("/login")
//  public boolean login(@RequestBody Usuario usuario){
//    return usuarioService.verificarLogin(usuario.getEmail(), usuario.getContrasenia());
//  }
}
