package com.ecomarket.servicio_usuarios.model;

@Entity
@Table(name="cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente extends Persona {

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String comuna;

}
