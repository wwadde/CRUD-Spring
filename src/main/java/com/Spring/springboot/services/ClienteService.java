package com.Spring.springboot.services;

import com.Spring.springboot.domain.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> findAllClientes();

    Cliente findClienteById(Integer id);

    Cliente saveCliente(Cliente cliente);

    Cliente updateCliente(Cliente cliente);

    Cliente deleteCliente(Integer id);
}
