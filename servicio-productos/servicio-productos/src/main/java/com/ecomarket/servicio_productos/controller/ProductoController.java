package com.ecomarket.servicio_productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.servicio_productos.model.Producto;
import com.ecomarket.servicio_productos.service.ProductoService;

@RestController
@RequestMapping("/api/v2/productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Listar todos los productos
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() {
        
        List<Producto> productos = productoService.findAll();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna error 204 si la lista está vacía
        }
        return ResponseEntity.ok(productos);

    }

    // Buscar un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.notFound().build(); // Retorna error 404 si no se encuentra el producto
        }
        return ResponseEntity.ok(producto);
    }


    // Crear un nuevo producto
    @PostMapping("/crear")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        if (producto.getId() != null) {
            return ResponseEntity.badRequest().build(); // Retorna error 400 si el ID ya está presente
        }
        Producto nuevoProducto = productoService.save(producto);
        return ResponseEntity.status(201).body(nuevoProducto); // Retorna error 201 al crear un nuevo producto
    }



}
