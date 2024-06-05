package com.Spring.springboot.services;

import com.Spring.springboot.domain.Producto;
import com.Spring.springboot.persistance.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductosServiceIMPL {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Producto getProducto(int id) {
        return productoRepository.findById(id).orElseThrow();
    }

    public Producto addProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto updateProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }
}
