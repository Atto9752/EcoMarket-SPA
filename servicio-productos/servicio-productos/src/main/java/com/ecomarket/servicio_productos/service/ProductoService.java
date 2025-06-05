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

    // Metodo buscar varios productos por una lista de ids
    public List<Producto> buscarPorVariasIds(List<Long> ids) {
        return productoRepository.findAllById(ids);
    }

    // Metodo crear producto
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    // Metodo actualizar producto
    public Producto update(Producto producto) {
        Long id = producto.getId();
        if (id == null || !productoRepository.existsById(id)) {
            throw new IllegalArgumentException("ID invalido.");
        }
        return productoRepository.save(producto);
    }

    // Metodo eliminar producto por id
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

}
