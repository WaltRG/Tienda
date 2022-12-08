package com.tienda;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Encriptar {
    
    public static void main(String[] args){
       BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
       var claveJuan = encoder.encode("123");
       var claveRebeca = encoder.encode("456");
       var clavePedro = encoder.encode("789");
       
       
       System.out.println("Juan (123): "+claveJuan);
       System.out.println("Rebeca (123): "+claveRebeca);
       System.out.println("Pedro (123): "+clavePedro);
       
       
    
}
}
