package com.ecomarket.servicio_carritos.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class carritoRequest {
    
    private List<Long> productos;
    
}
