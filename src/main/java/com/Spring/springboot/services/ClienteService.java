package com.Spring.springboot.services;

import com.Spring.springboot.domain.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findAllClientes();
    public Cliente findClienteById(Integer id);
    public Cliente saveCliente(Cliente cliente);
    public Cliente updateCliente(Cliente cliente);
    public Cliente deleteCliente(Integer id);
}
