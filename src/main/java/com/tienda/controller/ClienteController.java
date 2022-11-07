package com.tienda.controller;

import java.util.Arrays;
import com.tienda.domain.Cliente;
import com.tienda.dao.ClienteDao;
import com.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model){
        var texto = "Estamos en semana 4";
        model.addAttribute("mensaje", texto);
        
     
       var clientes = clienteService.getClientes(false);
        
       
        model.addAttribute("clientes", clientes);
        
        
        return "/cliente/listado";
    }
    
    

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {

        return "cliente/modificar";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);

        return "cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);

        return "redirect:/cliente/listado";
    }

}
