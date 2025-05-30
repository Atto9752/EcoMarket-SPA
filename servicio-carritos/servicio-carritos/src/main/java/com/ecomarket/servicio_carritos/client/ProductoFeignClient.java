package com.ecomarket.servicio_carritos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "servicio-productos", url = "http://localhost:8080/api/v3/productos")

public interface ProductoFeignClient {

}
