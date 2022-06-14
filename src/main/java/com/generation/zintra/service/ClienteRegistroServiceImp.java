package com.generation.zintra.service;

import com.generation.zintra.model.ClienteRegistro;
import com.generation.zintra.repository.ClienteRegistroRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Service
public class ClienteRegistroServiceImp implements ClienteRegistroService, UserDetailsService {

    private final ClienteRegistroRepository clienteRegistroRepository;

    public ClienteRegistroServiceImp(ClienteRegistroRepository clienteRegistroRepository) {
        this.clienteRegistroRepository = clienteRegistroRepository;
    }

    @Override
    public ClienteRegistro getClienteRegistro(Integer id) {
        Optional<ClienteRegistro> clienteRegistro = clienteRegistroRepository.findById(id);
        return clienteRegistro.orElse(null);
    }

    @Override
    public List<ClienteRegistro> getClienteRegistros() {
        return clienteRegistroRepository.findAll();
    }

    @Override
    public ClienteRegistro saveClienteRegistro(ClienteRegistro clienteRegistro) {
        return clienteRegistroRepository.save(clienteRegistro);
    }

    @Override
    public Boolean deleteClienteRegistro(Integer id) {
        try {
            clienteRegistroRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public ClienteRegistro updateClienteRegistro(ClienteRegistro clienteRegistro) {
        return clienteRegistroRepository.save(clienteRegistro);
    }

//    @Override
//    public boolean verificarLogin(String email, String contrasenia) {
//        List<Map<String, Object>> lista = clienteRegistroRepository.verificarLogin(email, contrasenia);
//        return !lista.isEmpty();
//    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        // Mandamos correo para buscar al usuario por correo
        ClienteRegistro clienteRegistro = clienteRegistroRepository.findByEmail(correo);

        if (clienteRegistro == null) {
            throw new UsernameNotFoundException(correo);
        }
        return new org.springframework.security.core.userdetails.User(clienteRegistro.getEmail(), clienteRegistro.getContrasenia(), emptyList());
    }


}
