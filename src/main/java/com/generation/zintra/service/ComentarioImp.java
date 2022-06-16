package com.generation.zintra.service;

import com.generation.zintra.model.Comentario;
import com.generation.zintra.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioImp implements ComentarioService {

    ComentarioRepository comentarioRepository;
    @Autowired //Si algo falla cambiar esta línea a la de abajo justo depués del paréntesis
    public ComentarioImp(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public Comentario getComentario(Integer id) {
        Optional<Comentario> comentario = comentarioRepository.findById(id);
        return comentario.orElse(null);
    }

    @Override
    public List<Comentario> getComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario saveComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public Boolean deleteComentario(Integer id) {
        try {
            comentarioRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Comentario updateComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }
}
