package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService{
    // se implenta el CRUD mediante ArticuloDAO
    
    //Se utiliza una anotacion AutoWired para que el objeto articuloDao
    //Si ya esta en memoria, se use ese, sino se crea (singleton)
    @Autowired
    private ArticuloDao articuloDao;
    
    
    @Override
    @Transactional(readOnly = true)
    //Retorna lita de articulos
    public List<Articulo> getArticulos(boolean activos){
        var lista= (List<Articulo>)articuloDao.findAll();
        
        if (activos){ //solos los articulos activos
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
    }
    
    
    @Override
    @Transactional(readOnly = true)
    //Dado un articulo.id se busca en la tabla y se retorna al objeto Articulo
    public Articulo getArticulo(Articulo articulo){
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }
    
    
    @Override
    @Transactional
    //Si articulo.id tiene valor, se busca y se actualiza
    //Si no tiene, se inserta el obajeto en tabla
    public void save(Articulo articulo){
        articuloDao.save(articulo);
    }
    
    @Override
    @Transactional
    //Elimina el registro que tiene el id igual a articulo.id
    public void delete(Articulo articulo){
        articuloDao.delete(articulo);
    }
    
}
