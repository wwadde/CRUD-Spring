package com.Spring.springboot.services;

import com.Spring.springboot.domain.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> findAll();

    public Producto saveProducto(Producto producto);

}
