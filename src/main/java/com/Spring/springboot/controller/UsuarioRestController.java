package com.Spring.springboot.controller;

import com.Spring.springboot.domain.Usuario;
import com.Spring.springboot.services.UsuariosServiceIMPL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuariosServiceIMPL usuarioService;

    @GetMapping()
    public ResponseEntity<?> getLista() {
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getUsuario(@PathVariable int id) {
        try {
            Usuario usuarioEncontrado = usuarioService.getUsuario(id);
            return ResponseEntity.ok(usuarioEncontrado);
        } catch (Exception e) {
            log.info("No se encontro el usuario con id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> postUsuario(@RequestBody Usuario usuario) {
        if (usuarioService.addUsuario(usuario)) {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(usuario.getId())
                    .toUri();
            usuarioService.addUsuario(usuario);
            return ResponseEntity.created(location).body(usuario);
        }
        log.error("No se pudo agregar el usuario");
        return ResponseEntity.badRequest().build();
    }

    @PutMapping()
    public ResponseEntity<?> putUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioActualizado = usuarioService.updateUsuario(usuario);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        }
        log.warn("No se pudo actualizar el usuario");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
        Optional usuario = usuarioService.deleteUsuario(id);
        if (usuario.isPresent()){
            return ResponseEntity.ok(usuario.get());
        }
        log.error("No se pudo eliminar el usuario con id: {}", id);
        return ResponseEntity.notFound().build();
    }


}


