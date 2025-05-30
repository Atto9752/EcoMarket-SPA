package com.ecomarket.servicio_carritos.model;

import lombok.Data;

@Data
public class ItemCarritoRequest {
    private Long productoId;
    private int cantidad;

}
