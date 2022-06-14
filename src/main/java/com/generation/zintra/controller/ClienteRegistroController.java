package com.generation.zintra.controller;

import com.generation.zintra.model.ClienteRegistro;
import com.generation.zintra.service.ClienteRegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/ClienteRegistro")
public class ClienteRegistroController {

  private final ClienteRegistroService clienteRegistroService; // Inyección de Service

  private final BCryptPasswordEncoder bCryptPasswordEncoder;


  public ClienteRegistroController(@Autowired ClienteRegistroService clienteRegistroService, @Autowired BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.clienteRegistroService = clienteRegistroService;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  // Leer
  @GetMapping("/{id}")
  public ClienteRegistro getClienteRegistro(@PathVariable Integer id) {
    return clienteRegistroService.getClienteRegistro(id);
  }

  @GetMapping("/all")
  public List<ClienteRegistro> getClienteRegistros() {
    return clienteRegistroService.getClienteRegistros();
  }

  // Escribir
  @PostMapping
  public ClienteRegistro saveClienteRegistro(@RequestBody ClienteRegistro clienteRegistro) {
    // Encriptando contraseña
    clienteRegistro.setContrasenia(bCryptPasswordEncoder.encode(clienteRegistro.getContrasenia()));
    // Guardando registro en bd
    return clienteRegistroService.saveClienteRegistro(clienteRegistro);
  }

  // Borrar
  @DeleteMapping("delete/{id}")
  public void deleteClienteRegistro(@PathVariable Integer id) {
    clienteRegistroService.deleteClienteRegistro(id);
  }

  // Actualizar
  @PutMapping
  public ClienteRegistro updateClienteRegistro(@RequestBody ClienteRegistro clienteRegistro) {
    return clienteRegistroService.updateClienteRegistro(clienteRegistro);
  }

  // Login
//  @PostMapping("/login")
//  public boolean login(@RequestBody ClienteRegistro clienteRegistro){
//    return clienteRegistroService.verificarLogin(clienteRegistro.getEmail(), clienteRegistro.getContrasenia());
//  }
}
