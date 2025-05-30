package com.ecomarket.servicio_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecomarket.servicio_productos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

    // No es ncesario agregar metodos aqui, JpaRepository ya se encarga del trabajo CRUD ;)

}
