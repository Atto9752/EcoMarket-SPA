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

    // Inyecta el RestTemplate configurado en config
    // Se instancia para poder usarlo en el servicio
    @Autowired
    private RestTemplate restTemplate;

    // Se establece la URL del microservicio productos para ser usada mas abajo en las peticiones HTTP
    private final String productosServiceURL = "http://localhost:8085/api/v3/productos/buscarVariosProductos";

    // Crear carrito con items
    public List<ProductoDto> crearCarrito(carritoRequest productosPorId) {
        // Toma los IDs del json de carritoRequest y los mete en una lista
        List<Long> ids = productosPorId.getProductos();
        List<ProductoDto> productos = obtenerProductosPorIds(ids);
        return productos;
        // no se retorna un getbody ya que esta dentro del metodo obtenerProductosPorIds
    }


    // Hace una peticion HTTP a servicio-productos para obtener los detalles de los productos por sus IDs
    // filtrados por la clase ProductoDto
    public List<ProductoDto> obtenerProductosPorIds(List<Long> ids) {
        // Se meten varias ids, y son transformadas en una peticion HTTP que solicita
        // varios productos por sus ID
        // Basicamente transforma un json de ids al lenguaje de una peticion HTTP
        HttpEntity<List<Long>> requestEntity = new HttpEntity<>(ids);
        
        ResponseEntity<List<ProductoDto>> response = restTemplate.exchange(
        productosServiceURL, // se le pasa la url del microservicio productos
        HttpMethod.POST, // se le pasa el metodo HTTP, en este caso POST
        requestEntity, // json transformado a una peticion HTTP
        new ParameterizedTypeReference<List<ProductoDto>>() {} );
        // Se le pasa el tipo de respuesta esperada, en este caso una lista de ProductoDto

        return response.getBody();
        // se retorna el cuerpo de la respuesta, que es una lista de ProductoDto
    }
}

