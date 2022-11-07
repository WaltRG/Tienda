package com.tienda.dao;

import com.tienda.domain.Articulo;
import com.tienda.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticuloDao extends JpaRepository<Articulo, Long> {
    
}
