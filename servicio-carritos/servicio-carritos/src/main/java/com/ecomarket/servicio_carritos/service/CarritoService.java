package com.ecomarket.servicio_carritos.service;

import com.ecomarket.servicio_carritos.model.*;
import com.ecomarket.servicio_carritos.repository.CarritoRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Transactional
public class CarritoService {
    
    @Autowired
    private CarritoRepository carritoRepository;

     @Autowired
    private RestTemplate restTemplate;

    // Comunicacion con el servicio de productos
     @Autowired
    private ProductoServiceRest productoServiceRest;

    private final String productosServiceURL = "http://localhost:8085/api/v3/productos/buscarVariosProductos";

    // Crear carrito con items
    public List<ProductoDto> crearCarrito(carritoRequest productosPorId) {
        //Se conectan los microservicios con RestTemplate, el cual trae los objetos tipo producto y los mete
        // en un objeto carritoRequest (Dto) llamado "items".
        // getForObject pide 2 argumentos: la URL del microservicio (en este caro el servicio-productos)
        // y el tipo de objeto que se espera recibir (en este caso carritoRequest).
        List<Long> ids = productosPorId.getProductos();

        List<ProductoDto> productos = obtenerProductosPorIds(ids);
        
        return productos;
    }

    public List<ProductoDto> obtenerProductosPorIds(List<Long> ids) {
        HttpEntity<List<Long>> requestEntity = new HttpEntity<>(ids);
    
        ResponseEntity<List<ProductoDto>> response = restTemplate.exchange(
        productosServiceURL,
        HttpMethod.POST,
        requestEntity,
        new ParameterizedTypeReference<List<ProductoDto>>() {} );

        return response.getBody();
    }
}

