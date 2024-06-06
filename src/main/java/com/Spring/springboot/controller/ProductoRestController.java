package com.Spring.springboot.controller;

import com.Spring.springboot.domain.Producto;
import com.Spring.springboot.services.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/productos")
public class ProductoRestController {

    @Autowired
    private ProductoService productosService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllProductos() {
        List<Producto> productos = productosService.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
        Producto savedProducto = productosService.saveProducto(producto);
        return new ResponseEntity<>(savedProducto, HttpStatus.CREATED);
    }

}
