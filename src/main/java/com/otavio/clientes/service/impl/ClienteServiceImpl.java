package com.otavio.clientes.service.impl;

import com.otavio.clientes.config.exception.ResourceNotFoundException;
import com.otavio.clientes.entity.Cliente;
import com.otavio.clientes.repository.ClienteRepository;
import com.otavio.clientes.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    public static final String ENTITY_NOT_FOUND = "Entidade não encontrada ";
    ClienteRepository clienteRepository;

    ClienteServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY_NOT_FOUND + id));
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
