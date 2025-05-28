package com.ecomarket.servicio_usuarios.controller;
import com.ecomarket.servicio_pedidos.service;

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
