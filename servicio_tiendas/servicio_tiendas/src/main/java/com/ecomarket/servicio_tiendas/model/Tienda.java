package com.ecomarket.servicio_tiendas.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tienda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable=false)
    private String nombreTienda;

    @Column(nullable=false)
    private String inventario;

    @Column(nullable=false)
    private String reportes;

    @Column(nullable=false)
    private String personalAsignado;
    
    @Column(nullable=false)
    private String horarioApertura;

    @Column(nullable=false)
    private String politicas;
}