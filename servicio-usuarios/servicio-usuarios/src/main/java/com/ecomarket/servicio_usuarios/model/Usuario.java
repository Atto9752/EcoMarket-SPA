package com.ecomarket.servicio_usuarios.model;  
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Usuario {

    protected Long idUsuario;
    protected String nombreUsuario;
    protected String apellidoUsuario;
    protected String correoUsuario;
    protected String contrasenaUsuario;
    protected String telefonoUsuario;
}
