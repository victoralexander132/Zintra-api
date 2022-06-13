package com.generation.zintra.service;

import java.util.List;
import com.generation.zintra.model.CarritoProducto;

public interface CarritoProductoService {

    CarritoProducto getCarritoProducto(Integer id);
    List<CarritoProducto> getCarritoProductos();
    CarritoProducto saveCarritoProducto(CarritoProducto compraCarrito);
    CarritoProducto updateClase(CarritoProducto compraCarrito);
    Boolean deleteCarritoProducto(Integer id);
}
