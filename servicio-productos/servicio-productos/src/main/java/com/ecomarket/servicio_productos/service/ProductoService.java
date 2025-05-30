package com.ecomarket.servicio_productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.servicio_productos.model.Producto;
import com.ecomarket.servicio_productos.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Metodo listar productos
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    // Metodo buscar producto por id
    public Producto findById(Long id) {
        return productoRepository.findById(id).get();
    }

    // Metodo guardar o actualizar producto por id
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    // Metodo eliminar producto por id
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

}
