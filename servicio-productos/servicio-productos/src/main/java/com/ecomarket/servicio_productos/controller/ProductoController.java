package com.ecomarket.servicio_productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.servicio_productos.model.Producto;
import com.ecomarket.servicio_productos.service.ProductoService;

@RestController
@RequestMapping("/api/v3/productos")

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Listar todos los productos
    @GetMapping("/listaProductos")
    public ResponseEntity<List<Producto>> listarProductos() {
        
        List<Producto> productos = productoService.findAll();
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna error si la lista está vacía
        }
        return ResponseEntity.ok(productos);

    }

    // Buscar un producto por ID
    @GetMapping("/buscarProducto/{id}")
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.notFound().build(); // Retorna error si no se encuentra el producto
        }
        return ResponseEntity.ok(producto);
    }

    // Buscar varios productos por una lista de IDs
    @PostMapping("/buscarVariosProductos")
    public ResponseEntity<List<Producto>> productosPorId(@RequestBody List<Long> ids){
        List<Producto> productos = productoService.buscarPorVariasIds(ids);
        return ResponseEntity.ok(productos);
    } 

    // Crear un nuevo producto
    @PostMapping("/crearProducto")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        if (producto.getId() != null) {
            return ResponseEntity.badRequest().build(); // Retorna error si el producto ya existe
        }
        Producto nuevoProducto = productoService.save(producto);
        return ResponseEntity.status(201).body(nuevoProducto);
    }

    // Actualizar un producto existente
    @PutMapping("/actualizarProducto")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
        if (producto.getId() == null || productoService.findById(producto.getId()) == null) {  // Para validar que el ID del producto no sea nulo y que también exista en la BD
            return ResponseEntity.badRequest().build(); // Retorna error si el ID es invalido
        }
        Producto productoActualizado = productoService.update(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    // Eliminar un producto por ID
    @DeleteMapping("/eliminarProducto/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
        if (productoService.findById(id) == null) {  // Verificar que el producto exista
            return ResponseEntity.notFound().build(); // Retorna error si no es asi
        }
        productoService.delete(id);
        return ResponseEntity.ok("Producto eliminado."); // Mensaje confirmacion
    }

}
