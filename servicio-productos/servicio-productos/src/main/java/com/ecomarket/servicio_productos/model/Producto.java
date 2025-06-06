package com.ecomarket.servicio_productos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;  // No es necesario pq @Data ya lo incluye
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")   // Nombre de la tabla en la base de datos
@Data
//@AllArgsConstructor  no es necesario con @Data
@NoArgsConstructor

public class Producto {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable = false)
    private String nombre;

    @Column(nullable = true)
    private String descripcion;

    @Column(nullable = false)
    private int precio;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private String categoria;
    
}

