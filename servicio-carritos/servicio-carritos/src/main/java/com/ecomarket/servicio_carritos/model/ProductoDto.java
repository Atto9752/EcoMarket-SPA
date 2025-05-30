package com.ecomarket.servicio_carritos.model;

import lombok.Data;

@Data
public class ProductoDto {
    private Long id;
    private String nombre;
    private int precio;
}
