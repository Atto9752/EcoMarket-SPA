package com.ecomarket.servicio_carritos.model;

import lombok.Data;

@Data
public class ProductoDto {
    private String nombre;
    private int precio;
    private int cantidad;
}
