package com.otavio.clientes.cliente.service;

import com.otavio.clientes.cliente.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente getClienteById(Long id);

    Cliente createCliente(Cliente cliente);

    List<Cliente> getAllClientes();

    Cliente updateCliente (Long id, Cliente cliente);

    void  deleteCliente (Long id);
}
