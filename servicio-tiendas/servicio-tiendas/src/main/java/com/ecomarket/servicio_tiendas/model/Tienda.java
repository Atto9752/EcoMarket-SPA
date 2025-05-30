package com.ecomarket.servicio_tiendas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tienda {
    
    private Integer id;
    private String nombreTienda;
    private String inventario;
    private String reportes;
    private String personalAsignado;
    private String horarioApertura;
    private String politicas;
}
