package com.ecomarket.servicio_tiendas.repository;

import com.ecomarket.servicio_tiendas.model.Tienda;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TiendaRepository {
    
    private List<Tienda> listaTiendas = new ArrayList<>();

    public List<Tienda> obtenerTiendas(){
        return listaTiendas;
    }
}
