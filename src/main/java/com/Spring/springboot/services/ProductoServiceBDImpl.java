package com.Spring.springboot.services;

import com.Spring.springboot.domain.Producto;
import com.Spring.springboot.persistance.entities.ProductoEntity;
import com.Spring.springboot.persistance.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("BD")
    @ConditionalOnProperty(
            value="productos.estrategia",
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
        public Producto saveProducto(Producto producto) {
            //Mapeo de Producto a ProductoEntity
            ProductoEntity productoEntity = new ProductoEntity();
            productoEntity.setNombre(producto.getNombre());
            productoEntity.setPrecio(producto.getPrecio());
            productoEntity.setStock(producto.getStock());
            ProductoEntity savedEntity = productosRepository.save(productoEntity);
            return mapToDto(savedEntity);
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



