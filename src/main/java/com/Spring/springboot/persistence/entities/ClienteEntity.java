package com.Spring.springboot.persistence.entities;

import com.googlecode.jmapper.annotations.JMap;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "clientes")
@Data
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JMap
    private Integer id;
    @JMap
    private String username;
    private String password;
    private String nombre;

}
