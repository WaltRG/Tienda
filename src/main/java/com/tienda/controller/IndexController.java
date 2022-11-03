package com.tienda.controller;

import java.util.Arrays;
import com.tienda.domain.Cliente;
import com.tienda.dao.ClienteDao;
import com.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var texto = "Estamos en semana 4";
        model.addAttribute("mensaje", texto);
        
       /* Cliente cliente1 = new Cliente("Juan", "Perez Moreno", "jperez@gmail.com","2222-4444");
        Cliente cliente2 = new Cliente("Pedro", "Moreno Peres", "pmoreno@gmail.com","2222-4444");
        Cliente cliente3 = new Cliente("Rebeca", "Perez Contreras", "rcontreras@gmail.com","2222-4444");
        
        var clientes = Arrays.asList(cliente1,cliente2,cliente3);*/
       
       var clientes = clienteService.getClientes();
        
       
        model.addAttribute("clientes", clientes);
        
        
        return "index";
    }
    
}
