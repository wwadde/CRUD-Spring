package com.Spring.springboot.services;

import com.Spring.springboot.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceIMPL {



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

    public List<Usuario> getUsuarios() {
        return lista;
    }

    public Usuario getUsuario(int id) {
        return lista.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst().orElseThrow();
    }

    public boolean addUsuario(Usuario usuario) {
        if (usuario.getUsername() != null && usuario.getEmail() != null) {
            if (usuario.getId() == 0) {
                usuario.setId(lista.size() + 1);
            }
            return lista.add(usuario);
        }
        return false;
    }

    public Usuario updateUsuario(Usuario usuario) {
        for (Usuario usuarioLista : lista) {
            if (usuarioLista.getId() == usuario.getId()) {
                usuarioLista.setUsername(usuario.getUsername());
                usuarioLista.setEmail(usuario.getEmail());
                return usuarioLista;
            }
        }
        return null;
    }

    public Optional deleteUsuario(int id) {
        Optional<Usuario> usuario = lista.stream()
                .filter(usu -> usu.getId() == id)
                .findFirst();
//        if (usuario.isPresent()) {
//            lista.remove(usuario.get());
//        }
        usuario.ifPresent(value -> System.out.println("Usuario eliminado: " + value));
        return usuario;
    }
}
