package com.generation.zintra.service;

import com.generation.zintra.model.Carrito;

import java.util.List;

public interface CarritoService {
	
	Carrito getCarrito(Integer id);
	List<Carrito> getCarritos();
	Carrito saveCarrito(Carrito carrito);
	Carrito updateClase(Carrito carrito);
	Boolean deleteCarrito(Integer id);
}
