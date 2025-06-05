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

    // Metodo listar usuaarios
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Metodo buscar usuario por correo
    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo).orElse(null);
    }

    // Metodo buscar usuario por id (esto solo se usa para poder eliminar un usuario, no para buscarlo)
    // ya que el usuario no se busca por id, sino por correo
    public Usuario findById(Long id) {
    return usuarioRepository.findById(id).orElse(null);
    }

    //Metodo eliminar usuario por id
    public void delete(Long id) {
        if (usuarioRepository.existsById(id)){  // Verifica que el usuario exista por su id
            usuarioRepository.deleteById(id);  // Elimina el usuario
        }
        else {
            throw new IllegalArgumentException("ID invalido.");
        }
    }

    // Metodo actualizar usuario por id
    public Usuario actualizarUsuario(Long id, Usuario usuarioCorregido){

        // Busca el usuario buscado y lo mete a la variable usuarioBuscado 
        // Si el usuario no existe, da nulo
        Usuario usuarioBuscado= usuarioRepository.findById(id).orElse(null);

        // Se verifica que el usuario exista y se actualizan sus datos
        if (usuarioBuscado != null) {
            usuarioBuscado.setRol(usuarioCorregido.getRol());
            usuarioBuscado.setNombre(usuarioCorregido.getNombre());
            usuarioBuscado.setApellido(usuarioCorregido.getApellido());
            usuarioBuscado.setCorreo(usuarioCorregido.getCorreo());
            usuarioBuscado.setContrasena(usuarioCorregido.getContrasena());
            usuarioBuscado.setTelefono(usuarioCorregido.getTelefono());
            usuarioBuscado.setDireccion(usuarioCorregido.getDireccion());
            usuarioBuscado.setComuna(usuarioCorregido.getComuna());
            return usuarioRepository.save(usuarioCorregido);
        } 
        else {
            throw new IllegalArgumentException("ID invalido.");
        }
    }

}
