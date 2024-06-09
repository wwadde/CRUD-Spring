package com.Spring.springboot.persistence.repositories;

import com.Spring.springboot.persistence.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<ClienteEntity,Integer> {

}
