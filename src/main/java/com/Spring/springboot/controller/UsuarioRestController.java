package com.Spring.springboot.controller;

import com.Spring.springboot.domain.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {

    private List<Usuario> lista = new ArrayList<>(Arrays.asList(
            new Usuario(1,"william","william@gmail.com"),
            new Usuario(2,"orlando","orlando@gmail.com"),
            new Usuario(3,"daniel","daniel@gmail.com"),
            new Usuario(4,"brayan","brayan@gmail.com"),
            new Usuario(5,"juan","juan@gmail.com"),
            new Usuario(6,"ruslan","ruslan@gmail.com"),
            new Usuario(7,"marina","marina@gmail.com"),
            new Usuario(8,"angela","angela@gmail.com"),
            new Usuario(9,"karen","karen@gmail.com"),
            new Usuario(10,"veratriz","veratriz@gmail.com")
    ));

    @GetMapping()
    public List<Usuario> getLista() {
        return lista;
    }




    @GetMapping("{id}")
    public Usuario getUsuario(@PathVariable int id) {
        return lista.stream().filter(cliente -> cliente.getId() == id).findFirst().orElseThrow();
    }

    @PostMapping()
    public String postUsuario(@RequestBody Usuario usuario) {

        lista.add(usuario);
        return "Usuario agregado con exito";
    }

    @PutMapping()
    public String putUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioEncontrado = lista.stream().filter(user -> user.getUsername().equalsIgnoreCase(user.getUsername())).findFirst().orElseThrow();
        usuarioEncontrado.setEmail(usuario.getEmail());
        usuarioEncontrado.setUsername(usuario.getUsername());
        return usuarioEncontrado.getUsername() + " actualizado con exito";


    }

    @DeleteMapping("{id}")
    public String deleteCliente(@PathVariable int id) {

        try{
        Usuario usuarioEncontrado = lista.stream().filter(usuario -> usuario.getId() == id).findFirst().orElseThrow();
        lista.remove(usuarioEncontrado);
        return usuarioEncontrado.getUsername() + " Eliminado con exito";
        }catch (Exception e){
            return "Usuario no encontrado";
        }
    }


}


