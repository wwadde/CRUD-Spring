package com.Spring.springboot.controller;

import com.Spring.springboot.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente("william.wadde", "123456", "William Wadde", "william@gmail.com"),
            new Cliente("brayan.alvarez", "321654", "Brayan Alvarez", "brayan@gmail.com"),
            new Cliente("ruslan.olaya", "15995", "Ruslan Olaya", "ruslan@.gmail.com"),
            new Cliente("juan.cardenas", "3216854", "Juan Cardenas", "juan@gmail.com")
    ));

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clientes;
    }


    // Explicar el metodo stream y el metodo filter
    @GetMapping("/clientes/{userName}")
    public Cliente getCliente(@PathVariable String userName) {
//        for (Cliente cliente : clientes) {
//            if (cliente.getUsername().equalsIgnoreCase(userName)) {
//                return cliente;
//            }
//        }
//        return null;
        return clientes.stream().filter(cliente -> cliente.getUsername().equalsIgnoreCase(userName)).findFirst().orElseThrow();
    }

    @PostMapping("/clientes/")
    public String postCliente(@RequestBody Cliente cliente) {

        clientes.add(cliente);
        return "Cliente agregado con exito";
    }

    @PutMapping("/clientes/{userName}")
    public String putCliente(@PathVariable String userName, @RequestBody Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getUsername().equalsIgnoreCase(userName)) {
                clientes.set(i, cliente);
                return "Cliente actualizado con exito";
            }
        }
        return "Cliente no encontrado";
    }

}


