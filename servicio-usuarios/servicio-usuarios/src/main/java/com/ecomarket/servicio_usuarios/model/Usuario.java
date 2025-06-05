package com.ecomarket.servicio_usuarios.model;  
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="usuario")
@Data
@NoArgsConstructor

public class Usuario {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String rol;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private Integer telefono;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String comuna;

}
