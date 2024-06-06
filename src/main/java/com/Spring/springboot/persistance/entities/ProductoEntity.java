package com.Spring.springboot.persistance.entities;

import com.googlecode.jmapper.annotations.JMap;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

    @Entity(name="productos")
    @Data
    public class ProductoEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @JMap
        private Integer id;
        @JMap
        private String nombre;
        private Double precio;
        private Integer stock;
    }
