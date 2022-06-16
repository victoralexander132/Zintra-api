package com.generation.zintra.service;

import com.generation.zintra.model.Usuario;
import com.generation.zintra.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class UsuarioServiceImp implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario getUsuario(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Boolean deleteUsuario(Integer id) {
        try {
            usuarioRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

//    @Override
//    public boolean verificarLogin(String email, String contrasenia) {
//        List<Map<String, Object>> lista = usuarioRepository.verificarLogin(email, contrasenia);
//        return !lista.isEmpty();
//    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        // Mandamos correo para buscar al usuario por correo
        Usuario usuario = usuarioRepository.findByEmail(correo);

        if (usuario == null) {
            throw new UsernameNotFoundException(correo);
        }
        return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getContrasenia(), emptyList());
    }


}
