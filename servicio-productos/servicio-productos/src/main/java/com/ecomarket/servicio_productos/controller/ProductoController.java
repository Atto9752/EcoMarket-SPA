package com.ecomarket.servicio_productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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


    // Actualizar un producto por ID
    @PostMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoExistente = productoService.findById(id);
        if (productoExistente == null) {
            return ResponseEntity.notFound().build(); // Retorna error 404 si no se encuentra el producto
        }
        producto.setId(id); // Aseguramos que el ID del producto a actualizar sea correcto
        Producto productoActualizado = productoService.save(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }



}
