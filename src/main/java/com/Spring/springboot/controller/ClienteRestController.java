package com.Spring.springboot.controller;

import com.Spring.springboot.domain.Cliente;
import com.Spring.springboot.services.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<?>> getAllClientes() {
        List<Cliente> clientes = clienteService.findAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClienteById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findClienteById(id);
        if (cliente == null) {
            log.warn("GET: Cliente con id {} no encontrado", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCliente(@RequestBody Cliente cliente) {
        if(cliente.getNombre() == null || cliente.getUsername() == null || cliente.getPassword() == null) {
            log.warn("POST: Cliente con campos nulos");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cliente savedCliente = clienteService.saveCliente(cliente);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(savedCliente);
    }

    @PutMapping
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente) {
        if (cliente.getId() == null) {
            log.warn("Id de producto nulo");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cliente clienteExistente = clienteService.updateCliente(cliente);
        if (clienteExistente == null) {
            log.warn("PUT: Cliente con id {} no existe", cliente.getId());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteExistente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Integer id) {
        Cliente clienteBorrado = clienteService.deleteCliente(id);
        if(clienteBorrado == null) {
            log.warn("DELETE: Cliente con id {} no encontrado", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(clienteBorrado, HttpStatus.OK);

    }

}
