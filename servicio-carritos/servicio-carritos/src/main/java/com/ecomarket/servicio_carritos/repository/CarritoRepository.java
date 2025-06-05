package com.ecomarket.servicio_carritos.repository;

import com.ecomarket.servicio_carritos.model.CarritoBD;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarritoRepository extends JpaRepository<CarritoBD, Long> {

}
