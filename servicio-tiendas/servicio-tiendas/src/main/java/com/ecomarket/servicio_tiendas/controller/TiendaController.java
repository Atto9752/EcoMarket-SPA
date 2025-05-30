package main.java.com.ecomarket.servicio_tiendas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecomarket.servicio_tiendas.model.Tienda;
import com.ecomarket.servicio_tiendas.service.TiendaService;

@RequestMapping("/api/v1/tiendas")
@RestController
public class TiendaController {
    
    @Autowired
    private TiendaService tiendaService;
    
    @GetMapping
    public ResponseEntity<List<Tienda>> listar(){
        
        List<Tienda> tiendas = tiendaService.findAll();
        if (tiendas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tiendas);

    }

}
