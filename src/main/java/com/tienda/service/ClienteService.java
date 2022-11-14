package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;


public interface ClienteService {
    // se define el CRUD
    
    //Retorna lita de clientes
    public List<Cliente> getClientes(boolean activos);
    
    //Dado un cliente.id se busca en la tabla y se retorna al objeto Cliente
    public Cliente getCliente(Cliente cliente);
    
    //Si cliente.id tiene valor, se busca y se actualiza
    //Si no tiene, se inserta el obajeto en tabla
    public void save(Cliente cliente);
    
    //Elimina el registro que tiene el id igual a cliente.id
    public void delete(Cliente cliente);
    
    //Retorna lista de clientes con apellidos especificos
    public List<Cliente> getClientesPorApellido(String apellidos);
    
}
