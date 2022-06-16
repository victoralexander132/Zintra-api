package com.generation.zintra.service;

import com.generation.zintra.model.Carrito;
import com.generation.zintra.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImp implements CarritoService {
    CarritoRepository carritoRepository;

    @Autowired
    public CarritoServiceImp(CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }


    @Override
    public Carrito getCarrito(Integer id) {
        Optional<Carrito> compraCarrito = carritoRepository.findById(id);
        return compraCarrito.orElse(null);
    }

    @Override
    public List<Carrito> getCarritos() {
        return carritoRepository.findAll();
    }

    @Override
    public Carrito saveCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public Carrito updateClase(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public Boolean deleteCarrito(Integer id) {
        try {
            carritoRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
