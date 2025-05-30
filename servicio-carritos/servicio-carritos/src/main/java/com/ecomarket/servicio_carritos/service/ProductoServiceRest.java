package com.ecomarket.servicio_carritos.service;

import com.ecomarket.servicio_carritos.model.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class ProductoServiceRest {
    private final String PRODUCTOS_API_URL = "http://localhost:8080/api/v3/productos"; // direccion microserv. productos

    @Autowired
    private RestTemplate restTemplate;

    // Obtener producto por ID + su url
    public ProductoDto getProductoById(Long id) {
        String url = PRODUCTOS_API_URL + "/buscarProducto/" + id;
        return restTemplate.getForObject(url, ProductoDto.class);
    }
}
