package com.ecomarket.servicio_carritos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "item_carrito")  // Nombre de la tabla en la base de datos
@Data
@NoArgsConstructor

public class ItemCarrito {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productoId;  

    @Column(nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private int precioUnitario;

    @Column(nullable = false)
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "carrito_id", nullable = false)  // Se hace la relacion con Carrito
    private Carrito carrito;

}
