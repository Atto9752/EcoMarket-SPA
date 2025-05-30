package com.ecomarket.servicio_carritos.service;

import com.ecomarket.servicio_carritos.client.ProductoFeignClient;
import com.ecomarket.servicio_carritos.model.*;
import com.ecomarket.servicio_carritos.repository.CarritoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService {
    
    @Autowired
    private CarritoRepository carritoRepository;

    // Comunicacion con el servicio de productos
    @Autowired
    private ProductoFeignClient productoFeignClient;

    // Crear carrito con items
    public Carrito crearCarrito(List<ItemCarritoRequest> itemsRequest) {
        Carrito carrito = new Carrito();
        List<ItemCarrito> items = new ArrayList<>();
        double total = 0;

        for (ItemCarritoRequest itemReq : itemsRequest) {
            // Conexion con productos para obtener producto x ID
            ProductoDto producto = productoFeignClient.buscarProductoPorId(itemReq.getProductoId());

            // Crear item carrito
            ItemCarrito item = new ItemCarrito();
            item.setProductoId(String.valueOf(producto.getId()));
            item.setNombreProducto(producto.getNombre());
            item.setPrecioUnitario(producto.getPrecio());
            item.setCantidad(itemReq.getCantidad());
            item.setCarrito(carrito);

            items.add(item);
            total += producto.getPrecio() * itemReq.getCantidad();
        }

        carrito.setItems(items);
        carrito.setTotal((int) total);
        return carritoRepository.save(carrito);
    }

}
