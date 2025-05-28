package com.ecomarket.servicio_usuarios.model;

@Entity
@Table(name="vendedor")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Vendedor extends Persona {

    @Column(nullable = false)
    private Date fechaContrato;

    @Column(nullable = false)
    private String turno;
}
