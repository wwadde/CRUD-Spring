package com.Spring.springboot.persistance.repositories;


import com.Spring.springboot.persistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository
        extends JpaRepository<ProductoEntity,Integer> {
    //HEREDA TODOS LOS METODOS DE JpaRepository
}

