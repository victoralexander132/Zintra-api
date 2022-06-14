package com.generation.zintra.repository;

import com.generation.zintra.model.ClienteRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRegistroRepository extends JpaRepository<ClienteRegistro, Integer> {

//   @Query(value = "SELECT nombre, email FROM cliente_registro WHERE email = ?1 AND contrasenia = ?2", nativeQuery = true)
//   List<Map<String, Object>> verificarLogin(String email, String contrasenia);

   ClienteRegistro findByEmail(String correo);

}
