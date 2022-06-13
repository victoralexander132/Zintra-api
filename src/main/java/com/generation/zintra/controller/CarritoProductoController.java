package com.generation.zintra.controller;

import com.generation.zintra.model.CarritoProducto;
import com.generation.zintra.service.CarritoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@RequestMapping(value = "api/CarritoProducto")
public class CarritoProductoController {

    private final CarritoProductoService carritoProductoService;

    @Autowired
    public CarritoProductoController(CarritoProductoService carritoProductoService) {
        this.carritoProductoService = carritoProductoService;
    }

    // Leer
    @GetMapping("/{id}")
    public CarritoProducto getCarritoProducto(@PathVariable Integer id) {
        return carritoProductoService.getCarritoProducto(id);
    }

    @GetMapping("/all")
    public List<CarritoProducto> getCarritoProductos() {
        return carritoProductoService.getCarritoProductos();
    }

    // Escribir
    @PostMapping
    public CarritoProducto saveCarritoProducto(@RequestBody CarritoProducto carritoProducto) {
        return carritoProductoService.saveCarritoProducto(carritoProducto);
    }

    // Borrar
    @DeleteMapping("delete/{id}")
    public void deleteCarritoProducto(@PathVariable Integer id) {
        carritoProductoService.deleteCarritoProducto(id);
    }

    // Actualizar
    @PutMapping
    public CarritoProducto updateCarritoProducto(@RequestBody CarritoProducto carritoProducto) {
        return carritoProductoService.updateClase(carritoProducto);
    }
}
