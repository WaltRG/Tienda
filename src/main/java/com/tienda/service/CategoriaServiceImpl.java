package com.tienda.service;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    // se implenta el CRUD mediante CategoriaDAO
    
    //Se utiliza una anotacion AutoWired para que el objeto categoriaDao
    //Si ya esta en memoria, se use ese, sino se crea (singleton)
    @Autowired
    private CategoriaDao categoriaDao;
    
    
    @Override
    @Transactional(readOnly = true)
    //Retorna lita de categorias
    public List<Categoria> getCategorias(boolean activos){
        
        var lista = (List<Categoria>)categoriaDao.findAll();
         if (activos){ //solos los articulos activos
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    //Dado un categoria.id se busca en la tabla y se retorna al objeto Categoria
    public Categoria getCategoria(Categoria categoria){
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
    
    @Override
    @Transactional
    //Si categoria.id tiene valor, se busca y se actualiza
    //Si no tiene, se inserta el obajeto en tabla
    public void save(Categoria categoria){
        categoriaDao.save(categoria);
    }
    
    @Override
    @Transactional
    //Elimina el registro que tiene el id igual a categoria.id
    public void delete(Categoria categoria){
        categoriaDao.delete(categoria);
    }
    
}
