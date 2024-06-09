package com.Spring.springboot.services;

import com.Spring.springboot.domain.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> findAll();
    public Producto findById(Integer id);
    public Producto saveProducto(Producto producto);
    public Producto updateProducto(Producto producto);
    public Producto deleteProducto(Integer id);



}
