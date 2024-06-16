package com.Spring.springboot.services;

import com.Spring.springboot.domain.Cliente;
import com.Spring.springboot.persistence.entities.ClienteEntity;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAllClientes();

    List<Cliente> findClienteByUsername(String username);

    Cliente findClienteById(Integer id);

    Cliente saveCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente);

    Cliente deleteCliente(Integer id);
}
