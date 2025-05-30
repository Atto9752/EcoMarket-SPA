package com.ecomarket.servicio_productos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producto")   // Nombre de la tabla en la base de datos
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Producto {

    // Atributos de la entidad Producto para la base de datos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true, nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true, length = 500)
    private String descripcion;

    @Column(nullable = false)
    private int precio;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false, length = 50)
    private String categoria;
    
}
