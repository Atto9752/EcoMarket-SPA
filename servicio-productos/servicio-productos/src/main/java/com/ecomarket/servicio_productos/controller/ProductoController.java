package com.ecomarket.servicio_productos.controller;

import java.util.List;
import com.ecomarket.servicio_productos.model.Producto;
import com.ecomarket.servicio_productos.service.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listaProductos() {
        return productoService.listaProductos();
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @GetMapping("{id}")
    public Producto buscarProducto(@PathVariable int id) {
        return productoService.getProductoId(id);
    }


}
