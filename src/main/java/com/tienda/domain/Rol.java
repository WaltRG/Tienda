package com.tienda.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name="rol")
public class Rol implements Serializable{
    
    private static final long serialVersionUID = 1L; //Modelo de ID incremental
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_rol")
    private long idRol;
    @NotEmpty
    private String nombre;
    

}