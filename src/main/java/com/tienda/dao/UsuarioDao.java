package com.tienda.dao;


import com.tienda.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioDao extends JpaRepository<Usuario, Long> {


    public Usuario findByUsername(String username);
    
}
