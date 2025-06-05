package com.ecomarket.servicio_carritos.model;

import java.util.List;

import lombok.Data;

@Data
public class CarritoModel {
    List<ProductoDto> productos;
}
