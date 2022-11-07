package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;


public interface ArticuloService {
    // se define el CRUD
    
    //Retorna lita de articulos
    public List<Articulo> getArticulos(boolean activos);
    
    //Dado un articulo.id se busca en la tabla y se retorna al objeto Articulo
    public Articulo getArticulo(Articulo articulo);
    
    //Si articulo.id tiene valor, se busca y se actualiza
    //Si no tiene, se inserta el obajeto en tabla
    public void save(Articulo articulo);
    
    //Elimina el registro que tiene el id igual a articulo.id
    public void delete(Articulo articulo);
    
}
