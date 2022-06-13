package com.generation.zintra.repository;

import com.generation.zintra.model.CarritoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CarritoProductoRepository extends JpaRepository<CarritoProducto, Integer>{


}
