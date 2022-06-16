package com.generation.zintra.controller;

import com.generation.zintra.model.Carrito;
import com.generation.zintra.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT })
@RequestMapping(value = "api/Carrito")
public class CarritoController {

    private final CarritoService carritoService;

    @Autowired
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    // Leer
    @GetMapping("/{id}")
    public Carrito getCarrito(@PathVariable Integer id) {
        return carritoService.getCarrito(id);
    }

    @GetMapping("/all")
    public List<Carrito> getCarritos() {
        return carritoService.getCarritos();
    }

    // Escribir
    @PostMapping
    public Carrito saveCarrito(@RequestBody Carrito carrito) {
        return carritoService.saveCarrito(carrito);
    }

    // Borrar
    @DeleteMapping("delete/{id}")
    public void deleteCarrito(@PathVariable Integer id) {
        carritoService.deleteCarrito(id);
    }

    // Actualizar
    @PutMapping
    public Carrito updateCarrito(@RequestBody Carrito carrito) {
        return carritoService.updateClase(carrito);
    }
}
