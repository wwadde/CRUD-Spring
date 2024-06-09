package com.Spring.springboot.services;

import com.Spring.springboot.domain.Producto;
import com.Spring.springboot.persistence.entities.ProductoEntity;
import com.Spring.springboot.persistence.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("BD")
@ConditionalOnProperty(
        value = "productos.estrategia",
        havingValue = "EN_BD")
public class ProductoServiceBDImpl implements ProductoService {

    @Autowired
    private ProductosRepository productosRepository;

    @Override
    public List<Producto> findAll() {
        List<ProductoEntity> entities = productosRepository.findAll();
        return entities.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public Producto findById(Integer id) {
        Optional<ProductoEntity> optionalEntity = productosRepository.findById(id);
        return optionalEntity.map(this::mapToDto).orElse(null);
    }

    @Override
    public Producto saveProducto(Producto producto) {
        // Mapeo de Producto a ProductoEntity
        ProductoEntity productoEntity = mapToEntity(producto);
        ProductoEntity savedEntity = productosRepository.save(productoEntity);
        // Tomar el ID generado y asignarlo al objeto Producto
        producto.setId(savedEntity.getId());
        return mapToDto(savedEntity);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        Optional<ProductoEntity> optionalEntity = productosRepository.findById(producto.getId());
        if (optionalEntity.isPresent()) {
            // Asumimos que producto no tiene campos null
            ProductoEntity updatedEntity = productosRepository.save(mapToEntity(producto));
            return mapToDto(updatedEntity);
        }
        return null;

    }

    @Override
    public Producto deleteProducto(Integer id) {
        Optional<ProductoEntity> optionalEntity = productosRepository.findById(id);
        if (optionalEntity.isPresent()) {
            productosRepository.deleteById(id);
            return optionalEntity.map(this::mapToDto).get();
        }
        return null;

    }


    private Producto mapToDto(ProductoEntity entity) {
        Producto dto = new Producto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setPrecio(entity.getPrecio());
        dto.setStock(entity.getStock());
        return dto;
    }

    private ProductoEntity mapToEntity(Producto dto) {
        ProductoEntity entity = new ProductoEntity();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setPrecio(dto.getPrecio());
        entity.setStock(dto.getStock());
        return entity;
    }

}



