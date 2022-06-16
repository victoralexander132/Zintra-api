package com.generation.zintra.service;

import com.generation.zintra.model.Comentario;

import java.util.List;


public interface ComentarioService {
    // Leer
    Comentario getComentario(Integer id);
    List<Comentario> getComentarios();

    // Guardar
    Comentario saveComentario(Comentario Comentario);

    // Borrar
    Boolean deleteComentario(Integer id);

    // Actualizar
    Comentario updateComentario(Comentario Comentario);

}