package com.ecomarket.servicio_usuarios.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario {

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String comuna;
}
