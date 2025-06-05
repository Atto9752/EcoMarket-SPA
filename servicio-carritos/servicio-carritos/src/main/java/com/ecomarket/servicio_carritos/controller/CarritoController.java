package com.ecomarket.servicio_carritos.controller;

import com.ecomarket.servicio_carritos.model.*;
import com.ecomarket.servicio_carritos.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    // Crear un nuevo carrito con items
    @PostMapping("/crearCarrito")
    public ResponseEntity<List<ProductoDto>> crearCarrito(@RequestBody carritoRequest items) {
        List<ProductoDto> carrito = carritoService.crearCarrito(items);
        return ResponseEntity.ok(carrito);
    }

    // Sintaxis POST:
    //  [
    //      { "productoId": 1, "cantidad": 2 },
    //      { "productoId": 2, "cantidad": 1 }
    //  ]

}
