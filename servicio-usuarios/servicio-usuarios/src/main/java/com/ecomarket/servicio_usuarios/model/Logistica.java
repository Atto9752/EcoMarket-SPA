package com.ecomarket.servicio_usuarios.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "logistica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logistica extends Usuario {

    @Column(nullable = false)
    private String zonaAsignada;

    @Column(nullable = false)
    private LocalDate fechaContrato;
}