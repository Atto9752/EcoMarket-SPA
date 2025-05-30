package com.ecomarket.servicio_carritos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "carrito")  // Nombre de la tabla en la base de datos
@Data
@NoArgsConstructor

public class Carrito {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String cliente;

    // Se establece la relacion con ItemCarrito
    // orphanRemoval permite eliminar los items del carrito si se eliminan de la lista
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCarrito> items;
    

    @Column(nullable = false)
    private int total;

}
