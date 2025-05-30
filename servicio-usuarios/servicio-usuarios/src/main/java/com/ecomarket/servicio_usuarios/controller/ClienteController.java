package com.ecomarket.servicio_usuarios.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.servicio_carritos.service;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private CarritoService carritoService;

    @PostMapping("/{clienteId}/carrito/agregar")
    public ResponseEntity<Carrito> agregarProducto(
        @PathVariable Long clienteId,
        @RequestBody AgregarProductoRequest request) {

        Carrito carritoActualizado = carritoService.agregarProductoAlCarrito(
            clienteId, request.getProductoId(), request.getCantidad());

        return ResponseEntity.ok(carritoActualizado);
    }
}
