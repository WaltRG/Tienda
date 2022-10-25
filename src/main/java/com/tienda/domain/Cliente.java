package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L; //Modelo de ID incremental
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCliente;
    
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    


public Cliente(){

}

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }



}