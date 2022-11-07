package com.tienda.controller;

import java.util.Arrays;
import com.tienda.domain.Articulo;
import com.tienda.dao.ArticuloDao;
import com.tienda.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @Autowired
    private ArticuloService articuloService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
       var articulos = articuloService.getArticulos(true);
        
       
        model.addAttribute("articulos", articulos);
        
        
        return "index";
    }
    
}
