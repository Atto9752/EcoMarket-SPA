package com.ecomarket.servicio_tiendas.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecomarket.servicio_tiendas.Repository.TiendaRepository;
import com.ecomarket.servicio_tiendas.model.Tienda;

@Service
public class TiendaService {
    
    @Autowired
    private TiendaRepository tiendaRepository;

}
