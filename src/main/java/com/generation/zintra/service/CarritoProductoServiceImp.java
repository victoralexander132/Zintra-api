package com.generation.zintra.service;

import com.generation.zintra.model.CarritoProducto;
import com.generation.zintra.repository.CarritoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoProductoServiceImp implements CarritoProductoService{
    CarritoProductoRepository compraCarritoRepository;

    @Autowired
    public CarritoProductoServiceImp(CarritoProductoRepository compraCarritoRepository) {
        this.compraCarritoRepository = compraCarritoRepository;
    }


    @Override
    public CarritoProducto getCarritoProducto(Integer id) {
        Optional<CarritoProducto> compraCarrito = compraCarritoRepository.findById(id);
        return compraCarrito.orElse(null);
    }

    @Override
    public List<CarritoProducto> getCarritoProductos() {
        return compraCarritoRepository.findAll();
    }

    @Override
    public CarritoProducto saveCarritoProducto(CarritoProducto compraCarrito) {
        return compraCarritoRepository.save(compraCarrito);
    }

    @Override
    public CarritoProducto updateClase(CarritoProducto compraCarrito) {
        return compraCarritoRepository.save(compraCarrito);
    }

    @Override
    public Boolean deleteCarritoProducto(Integer id) {
        try {
            compraCarritoRepository.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
