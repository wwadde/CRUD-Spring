package com.Spring.springboot.services;

import com.Spring.springboot.domain.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> findAll();

    Producto findById(Integer id);

    Producto saveProducto(Producto producto);

    Producto updateProducto(Producto producto);

    Producto deleteProducto(Integer id);


}
