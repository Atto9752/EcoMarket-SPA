package com.ecomarket.servicio_usuarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="gerente")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor

public class Gerente extends Persona  {
    @OneToOne
    @JoinColumn(name = "tienda_id", nullable = false)
    private Tienda tiendaAsignada;
}
