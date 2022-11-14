package com.tienda.dao;

import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ClienteDao extends JpaRepository<Cliente, Long> {

    
    //@Query("SELECT P FROM Cliente p WHERE p.apellidos LIKE %1?%")
    public List<Cliente> findByApellidos(String apellidos);
    
}
