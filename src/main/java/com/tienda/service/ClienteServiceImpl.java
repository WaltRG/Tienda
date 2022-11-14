package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
    // se implenta el CRUD mediante ClienteDAO
    
    //Se utiliza una anotacion AutoWired para que el objeto clienteDao
    //Si ya esta en memoria, se use ese, sino se crea (singleton)
    @Autowired
    private ClienteDao clienteDao;
    
    //Se utiliza una anotacion AutoWired para que el objeto creditoDao
    //Si ya esta en memoria, se use ese, sino se crea (singleton)
    @Autowired
    private CreditoDao creditoDao;
    
    
    @Override
    @Transactional(readOnly = true)
    //Retorna lita de clientes
    public List<Cliente> getClientes(boolean activos){
        return (List<Cliente>)clienteDao.findAll();
    }
    
    
    @Override
    @Transactional(readOnly = true)
    //Dado un cliente.id se busca en la tabla y se retorna al objeto Cliente
    public Cliente getCliente(Cliente cliente){
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }
    
    
    @Override
    @Transactional
    //Si cliente.id tiene valor, se busca y se actualiza
    //Si no tiene, se inserta el obajeto en tabla
    public void save(Cliente cliente){
        Credito credito = cliente.getCredito();
        
        credito = creditoDao.save(credito);
        
        cliente.setCredito(credito);
        
        clienteDao.save(cliente);
    }
    
    @Override
    @Transactional
    //Elimina el registro que tiene el id igual a cliente.id
    public void delete(Cliente cliente){
        clienteDao.delete(cliente);
    }

    @Override
    public List<Cliente> getClientesPorApellido(String apellidos) {
        return clienteDao.findByApellidos(apellidos);
    }
    
    
    
    
    
}
