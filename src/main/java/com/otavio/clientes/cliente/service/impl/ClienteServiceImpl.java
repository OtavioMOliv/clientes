package com.otavio.clientes.cliente.service.impl;

import com.otavio.clientes.categoria.repository.CategoriaRepository;
import com.otavio.clientes.config.exception.ResourceNotFoundException;
import com.otavio.clientes.cliente.dto.ClienteDto;
import com.otavio.clientes.cliente.entity.Cliente;
import com.otavio.clientes.cliente.repository.ClienteRepository;
import com.otavio.clientes.cliente.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    public static final String ENTITY_NOT_FOUND = "Entidade não encontrada ";
    ClienteRepository clienteRepository;
    CategoriaRepository categoriaRepository;

    ClienteServiceImpl(ClienteRepository clienteRepository, CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY_NOT_FOUND + id));
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        if(cliente.getCategoria() != null && cliente.getCategoria().getId() != null){
            cliente.setCategoria(categoriaRepository.getReferenceById(cliente.getCategoria().getId()));
        }else{
            // TODO criar uma exceção caso categoria seja obrigatório
            cliente.setCategoria(null);
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        cliente.setId(id);
        return  clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
         clienteRepository.deleteById(id);
    }
}