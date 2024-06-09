package com.Spring.springboot.services;

import com.Spring.springboot.domain.Cliente;
import com.Spring.springboot.persistence.entities.ClienteEntity;
import com.Spring.springboot.persistence.repositories.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("BD")
@ConditionalOnProperty(
        value = "clientes.estrategia",
        havingValue = "EN_BD")
public class ClienteServiceBDImpl implements ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;


    @Override
    public List<Cliente> findAllClientes() {
        List<ClienteEntity> entities = clientesRepository.findAll();
        return entities.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public Cliente findClienteById(Integer id) {
        Optional<ClienteEntity> optionalEntity = clientesRepository.findById(id);
        return optionalEntity.map(this::mapToDto).orElse(null);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {

        ClienteEntity clienteEntity = mapToEntity(cliente);
        ClienteEntity savedEntity = clientesRepository.save(clienteEntity);
        cliente.setId(savedEntity.getId());
        return mapToDto(savedEntity);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        Optional<ClienteEntity> optionalEntity = clientesRepository.findById(cliente.getId());
        if (optionalEntity.isPresent()) {
            ClienteEntity updatedEntity = clientesRepository.save(mapToEntity(cliente));
            return mapToDto(updatedEntity);
        }
        return null;

    }

    @Override
    public Cliente deleteCliente(Integer id) {
        Optional<ClienteEntity> optionalEntity = clientesRepository.findById(id);
        if (optionalEntity.isPresent()) {
            clientesRepository.deleteById(id);
            return optionalEntity.map(this::mapToDto).get();
        }
        return null;
    }

    private Cliente mapToDto(ClienteEntity entity) {
        Cliente dto = new Cliente();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setUsername(entity.getUsername());
        return dto;
    }

    private ClienteEntity mapToEntity(Cliente dto) {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
