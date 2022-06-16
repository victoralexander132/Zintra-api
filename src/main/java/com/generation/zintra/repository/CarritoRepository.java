package com.generation.zintra.repository;

import com.generation.zintra.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer>{


}
