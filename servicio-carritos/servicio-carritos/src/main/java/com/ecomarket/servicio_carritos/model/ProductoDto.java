package com.ecomarket.servicio_carritos.model;

import lombok.Data;

@Data
// Se usa para traer los datos filtrados de los productos del microservicio "servicio-productos"
// Este DTO se usa para crear un carrito con los productos seleccionados por el usuario
public class ProductoDto {
    private String nombre;
    private int precio;
}
