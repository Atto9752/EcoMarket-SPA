package com.ecomarket.servicio_usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.servicio_usuarios.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Metodo personalizado para buscar usuario x correo
    Optional<Usuario> findByCorreo(String correo);
    
    // No es necesario agregar mas metodos, JpaRepository ya se encarga del trabajo CRUD ;)
}