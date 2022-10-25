package com.tienda.dao;

import com.tienda.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteDao extends JpaRepository<Cliente, Long> {
    
}
