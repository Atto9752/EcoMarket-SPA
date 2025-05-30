package com.ecomarket.servicio_usuarios.model;

@Entity
@Table(name="gerente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Gerente extends Persona  {
    @OneToOne
    @JoinColumn(name = "tienda_id", nullable = false)
    private Tienda tiendaAsignada;
}
