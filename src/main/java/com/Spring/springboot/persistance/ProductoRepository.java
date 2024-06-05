package com.Spring.springboot.persistance;

import com.Spring.springboot.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    }

