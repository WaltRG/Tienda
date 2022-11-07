package com.tienda.dao;


import com.tienda.domain.Credito;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CreditoDao extends JpaRepository<Credito, Long> {
    
}
