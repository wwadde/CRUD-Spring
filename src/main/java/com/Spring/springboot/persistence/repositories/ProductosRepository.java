package com.Spring.springboot.persistence.repositories;


import com.Spring.springboot.persistence.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<ProductoEntity,Integer> {
    //HEREDA TODOS LOS METODOS DE JpaRepository
}

