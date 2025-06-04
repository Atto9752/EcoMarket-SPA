package com.ecomarket.servicio_usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.servicio_usuarios.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // No es necesario agregar metodos aqui, JpaRepository ya se encarga del trabajo CRUD ;)
    // se pueden agregar metodos personalizados como por ej:
    // Optional<Usuario> findByCorreo(String correo);
    // Optional<Usuario> findByTelefono(Integer telefono);
    // etc
}