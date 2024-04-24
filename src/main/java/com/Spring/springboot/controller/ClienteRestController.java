package com.Spring.springboot.controller;

import com.Spring.springboot.domain.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteRestController {

    private List<Cliente> clientes = new ArrayList<>(Arrays.asList(
            new Cliente(1,"william","william@gmail.com"),
            new Cliente(2,"orlando","orlando@gmail.com"),
            new Cliente(3,"daniel","daniel@gmail.com"),
            new Cliente(4,"brayan","brayan@gmail.com"),
            new Cliente(5,"juan","juan@gmail.com"),
            new Cliente(6,"ruslan","ruslan@gmail.com"),
            new Cliente(7,"marina","marina@gmail.com"),
            new Cliente(8,"angela","angela@gmail.com"),
            new Cliente(9,"karen","karen@gmail.com"),
            new Cliente(10,"veratriz","veratriz@gmail.com")
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

    @PutMapping("/put/{userName}")
    public String putCliente(@PathVariable String userName, @RequestBody Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getUsername().equalsIgnoreCase(userName)) {
                clientes.set(i, cliente);
                return clientes.get(i).getUsername() + "actualizado con exito";
            }
        }
        return "Cliente no encontrado";
    }

    @DeleteMapping("/delete/{userName}")
    public String deleteCliente(@PathVariable String userName) {
        for (Cliente cliente : clientes){
            if (cliente.getUsername().equalsIgnoreCase(userName)){
                clientes.remove(cliente);
                return "Cliente " + cliente.getUsername() + " eliminado con exito";
            }
        }
        return "Cliente no encontrado";
    }

}


