package com.ecomarket.servicio_productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.servicio_productos.model.Producto;
import com.ecomarket.servicio_productos.service.ProductoService;

@RestController
@RequestMapping("/api/v2/productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;


    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        
        List<Producto> productos = productoService.findAll();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna error 204 si la lista está vacía
        }
        return ResponseEntity.ok(productos);

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
