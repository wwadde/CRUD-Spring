package com.Spring.springboot.controller;

import com.Spring.springboot.domain.Producto;
import com.Spring.springboot.services.ProductoService;
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
@RequestMapping("/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService productosService;

    @GetMapping
    public ResponseEntity<List<?>> getAllProductos() {
        List<Producto> productos = productosService.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable Integer id) {
        Producto producto = productosService.findById(id);
        if (producto == null) {
            log.warn("GET: Producto con id {} no encontrado", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProducto(@RequestBody Producto producto) {
        if(producto.getNombre() == null || producto.getPrecio() == null || producto.getStock() == null) {
            log.warn("POST: Producto con campos nulos");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Producto savedProducto = productosService.saveProducto(producto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(producto.getId())
                .toUri();
        // Uso del metodo en lugar del constructor
        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(producto);
    }

    @PutMapping
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto) {
        if (producto.getId() == null) {
            log.warn("Id de producto nulo");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Producto productoExiste = productosService.updateProducto(producto);
        if (productoExiste == null) {
            log.warn("PUT: Producto con id {} no existe", producto.getId());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productoExiste, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Integer id) {
        Producto productoBorrado = productosService.deleteProducto(id);
        if(productoBorrado == null) {
            log.warn("DELETE: Producto con id {} no encontrado", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productoBorrado, HttpStatus.OK);

    }


}
