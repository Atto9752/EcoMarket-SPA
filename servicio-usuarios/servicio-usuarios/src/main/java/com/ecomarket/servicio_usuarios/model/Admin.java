package com.ecomarket.servicio_usuarios.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "administrador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin extends Usuario {

    @Column(nullable = false)
    private LocalDate fechaContrato;

    //Manera de ingresar datos en PostMan de tipo LocalDate ("2024-05-25")
}
