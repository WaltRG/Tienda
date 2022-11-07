package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    // se define el CRUD
    
    //Retorna lita de categorias
    public List<Categoria> getCategorias(boolean activos);
    
    //Dado un categoria.id se busca en la tabla y se retorna al objeto Categoria
    public Categoria getCategoria(Categoria categoria);
    
    //Si categoria.id tiene valor, se busca y se actualiza
    //Si no tiene, se inserta el obajeto en tabla
    public void save(Categoria categoria);
    
    //Elimina el registro que tiene el id igual a categoria.id
    public void delete(Categoria categoria);
    
}
