package com.ecomarket.servicio_carritos.service;

import com.ecomarket.servicio_carritos.model.ProductoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class ProductoServiceRest {
    private final String PRODUCTOS_API_URL = "http://localhost:8080/api/v3/productos"; // direccion microserv. productos

    @Autowired
    private RestTemplate restTemplate;

    // Obtener producto por ID + su url
    public ProductoDto getProductoById(Long id) {
    try {
        String url = PRODUCTOS_API_URL + "/buscarProducto/" + id;
        ResponseEntity<ProductoDto> response = restTemplate.getForEntity(url, ProductoDto.class);
        
        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
            throw new RuntimeException("Producto no encontrado o error en servicio-productos");
        }
        return response.getBody();
    } catch (Exception e) {
        throw new RuntimeException("Error al llamar servicio-productos: " + e.getMessage());
    }
}
}
