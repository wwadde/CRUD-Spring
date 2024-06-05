package com.Spring.springboot.services;

import com.Spring.springboot.domain.Producto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductosServiceIMPL {

    private List<Producto> productos = new ArrayList<>(Arrays.asList(
            new Producto(1,"Televisor",100.0,10),
            new Producto(2,"Tablet",200.0,20),
            new Producto(3,"Celular",300.0,30),
            new Producto(4,"Nevera",400.0,40),
            new Producto(5,"Lavadora",500.0,50),
            new Producto(6,"CortaCesped",600.0,60),
            new Producto(7,"Parlante",700.0,70),
            new Producto(8,"Computador",800.0,80),
            new Producto(9,"Licuadora",900.0,90),
            new Producto(10,"GPU",1000.0,100)

    ));

    public List<Producto> getProductos() {
        return productos;
    }

    // TODO agregar validaciones

    public Producto getProducto(int id) {
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst().orElseThrow();
    }

    public boolean addProducto(Producto producto) {

        if (producto.getId() == null) {
            producto.setId(productos.size() + 1);
        }

        if (producto.getNombre() != null && producto.getPrecio() != null && producto.getStock() != null) {

            return productos.add(producto);
        }
        return false;
    }

    public Producto updateProducto(Producto producto) {

        for (Producto productoLista : productos) {
            if (productoLista.getId().equals(producto.getId())) {
                productoLista.setNombre(producto.getNombre());
                productoLista.setPrecio(producto.getPrecio());
                productoLista.setStock(producto.getStock());
                return productoLista;
            }
        }
        return null;
    }

    public Optional deleteProducto(int id) {
        Optional<Producto> producto = productos.stream()
                .filter(pro -> pro.getId() == id)
                .findFirst();
        producto.ifPresent(value -> productos.remove(value));
        return producto;
    }
}
