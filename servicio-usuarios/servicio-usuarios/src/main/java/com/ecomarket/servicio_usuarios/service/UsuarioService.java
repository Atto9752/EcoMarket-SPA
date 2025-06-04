package com.ecomarket.servicio_usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.servicio_usuarios.model.Usuario;
import com.ecomarket.servicio_usuarios.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Metodo crear usuario
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticar(String correo, String contrasena) {
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            if (usuario.getContrasenaUsuario().trim().equals(contrasena.trim())) {
                return usuario;
            }   
        }
        return null;
    }
}
