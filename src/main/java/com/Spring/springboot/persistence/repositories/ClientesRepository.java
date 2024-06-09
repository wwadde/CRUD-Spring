package com.Spring.springboot.persistance.repositories;

import com.Spring.springboot.persistance.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClienteEntity,Integer> {

}
