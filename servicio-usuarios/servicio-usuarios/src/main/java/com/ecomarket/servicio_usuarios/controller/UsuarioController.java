package com.ecomarket.servicio_usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.servicio_usuarios.model.Usuario;
import com.ecomarket.servicio_usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/v2/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Crear un nuevo usuario
    @PostMapping("/crearUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        if (usuario.getId() != null) {
            return ResponseEntity.badRequest().build(); // Retorna error si el usuario ya existe
        }
        Usuario nuevoUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(201).body(nuevoUsuario);
    }

    // Listar usuarios
    @GetMapping("/listaUsuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        if (usuarios.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna error si la lista está vacía
        }
        return ResponseEntity.ok(usuarios);
    }

    // Buscar un usuario por correo
    @GetMapping("/buscarUsuario/{correo}")
    public ResponseEntity<Usuario> buscarUsuarioPorCorreo(@PathVariable String correo) {
        Usuario usuario = usuarioService.findByCorreo(correo);
        if (usuario == null) {
            return ResponseEntity.notFound().build(); // Retorna error si no se encuentra el usuario
        }
        return ResponseEntity.ok(usuario);
    }

    // Eliminar usuario por id
    @DeleteMapping("/eliminarUsuario/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long id) {
        if (usuarioService.findById(id) == null) {  // Verificar que el producto exista
            return ResponseEntity.notFound().build(); // Retorna error si no es asi
        }
        usuarioService.delete(id);
        return ResponseEntity.ok("Usuario eliminado."); // Mensaje confirmacion
    }

    // Actualizar usuario por id
    @PutMapping("/actualizarUsuario/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }
}
