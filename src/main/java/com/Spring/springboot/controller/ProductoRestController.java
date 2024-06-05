package com.Spring.springboot.controller;

import com.Spring.springboot.domain.Producto;
import com.Spring.springboot.services.ProductosServiceIMPL;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/productos")
public class ProductoRestController {

    @Autowired
    private ProductosServiceIMPL productosService;


    @GetMapping
    public ResponseEntity<?> getProductos() {
        return ResponseEntity.ok(productosService.getProductos());
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getProducto(@PathVariable int id) {

        try {
            Producto productoEncontrado = productosService.getProducto(id);
            return ResponseEntity.ok(productoEncontrado);

        } catch (Exception e) {
            log.info("No se encontro el producto con id: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> postProducto(@RequestBody Producto producto) {

        Producto productoExiste = productosService.addProducto(producto);
        if (productoExiste != null) {

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(producto.getId())
                    .toUri();
            return ResponseEntity.created(location).body(producto);
        }
        return ResponseEntity.badRequest().build();

    }

    @PutMapping()
    public ResponseEntity<?> putProducto(@RequestBody Producto producto) {

        Producto p = productosService.updateProducto(producto);
        if (p != null) {
            return ResponseEntity.ok(p);
        }
        log.warn("No se encontro el producto con id: {}", producto.getId());
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable int id) {
        productosService.deleteProducto(id);

            return ResponseEntity.ok().build();

    }
}
