package com.ecomarket.servicio_carritos.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// Json que se pone en postman en la url para crear carrito
// Ejemplo: {"productos":[1,2,3]}
public class carritoRequest {
    
    private List<Long> productos;
    
}
