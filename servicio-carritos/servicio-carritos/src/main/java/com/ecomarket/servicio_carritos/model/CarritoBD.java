package com.ecomarket.servicio_carritos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
// Para guardar un carrito en bd
public class CarritoBD {
    @Id
    private Long id;
}
