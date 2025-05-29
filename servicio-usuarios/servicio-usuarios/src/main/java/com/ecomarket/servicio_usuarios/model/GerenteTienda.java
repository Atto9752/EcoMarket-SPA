package com.ecomarket.servicio_usuarios.model;

@Entity
@Table(name = "gerente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GerenteTienda extends Usuario {

    @Column(nullable = false)
    private String nombreTienda; 

    @Column(nullable = false)
    private LocalDate fechaContrato;
}