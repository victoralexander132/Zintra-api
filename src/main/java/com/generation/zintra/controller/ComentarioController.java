package com.generation.zintra.controller;

import com.generation.zintra.model.Comentario;
import com.generation.zintra.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@RequestMapping(value = "api/Comentario")
public class ComentarioController {

  private final ComentarioService comentarioService;

  @Autowired
  public ComentarioController(ComentarioService comentarioService) {
    this.comentarioService = comentarioService;
  }

  // Leer
  @GetMapping("/{id}")
  public Comentario getComentario(@PathVariable Integer id) {
    return comentarioService.getComentario(id);
  }

  @GetMapping("/all")
  public List<Comentario> getComentarios() {
    return comentarioService.getComentarios();
  }

  // Escribir
  @PostMapping
  public Comentario saveComentario(@RequestBody Comentario comentario) {
    return comentarioService.saveComentario(comentario);
  }

  // Borrar
  @DeleteMapping("delete/{id}")
  public void deleteComentario(@PathVariable Integer id) {
    comentarioService.deleteComentario(id);
  }

  // Actualizar
  @PutMapping
  public Comentario updateComentario(@RequestBody Comentario comentario) {
    return comentarioService.updateComentario(comentario);
  }


}
