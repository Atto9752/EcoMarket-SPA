package com.ecomarket.servicio_usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecomarket.servicio_usuarios.model.Cliente;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(usuarioService.crearCliente(cliente));
    }

    @PostMapping("/admins")
    public ResponseEntity<Admin> crearAdmin(@RequestBody Admin admin) {
        return ResponseEntity.ok(usuarioService.crearAdmin(admin));
    }

    @PostMapping("/gerentes")
    public ResponseEntity<GerenteTienda> crearGerente(@RequestBody GerenteTienda gerente) {
        return ResponseEntity.ok(usuarioService.crearGerente(gerente));
    }

    @PostMapping("/logistica")
    public ResponseEntity<Logistica> crearLogistica(@RequestBody Logistica logistica) {
        return ResponseEntity.ok(usuarioService.crearLogistica(logistica));
    }

    @Autowired
    private UsuarioService usuarioService;

    //Se utiliza ResponseEntity<?> para mas flexibilidad, ya que el metodo puede devolver un objeto o un String en caso de error

    @PostMapping("/login")
    public ResponseEntity<?> autenticarUsuario(@RequestParam String correo, @RequestParam String contrasena) {
        Usuario usuarioAutenticado = usuarioService.autenticarUsuario(correo, contrasena);

        if (usuarioAutenticado != null) {
            return ResponseEntity.ok(usuarioAutenticado); // Devuelve el usuario autenticado
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos");
        }
    }
}
