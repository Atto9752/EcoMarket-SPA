package main.java.com.ecomarket.servicio_tiendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomarket.servicio_tiendas.model.Tienda;
import com.ecomarket.servicio_tiendas.repository.TiendaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TiendaService {
    @Autowired
    private TiendaRepository tiendaRepository;

    public List<Tienda> findAll(){
        return tiendaRepository.findAll();
    }

    public Tienda findById(long id){
        return tiendaRepository.findById(id).get();
    }

    public Tienda save(Tienda tienda){
        return tiendaRepository.save(tienda);
    }

    public void delete(Long id){
        tiendaRepository.deleteById(id);
    }
}
