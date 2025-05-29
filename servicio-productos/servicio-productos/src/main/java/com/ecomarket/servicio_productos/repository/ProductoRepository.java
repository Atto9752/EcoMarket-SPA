package com.ecomarket.servicio_productos.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecomarket.servicio_productos.model.Producto;

@Repository
public class ProductoRepository {

    // Creamos la lista de productos
    private List<Producto> listaProductos = new ArrayList<>();

    // Metodo para ver la lista de productos
    public List<Producto> listaProductos() {
        return listaProductos;
    }



}
