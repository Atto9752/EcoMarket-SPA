package com.ecomarket.servicio_carritos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.ecomarket.servicio_carritos.model.ProductoDto;

@FeignClient(name = "servicio-productos", url = "http://localhost:8080/api/v3/productos")

public interface ProductoFeignClient {
    @GetMapping("/api/v3/productos/buscarProducto/{id}")
    ProductoDto buscarProductoPorId(@PathVariable Long id);
}
