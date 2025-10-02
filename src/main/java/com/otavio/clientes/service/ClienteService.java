package com.otavio.clientes.service;

import com.otavio.clientes.entity.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente getClienteById(Long id);

    Cliente createCliente(Cliente cliente);

    List<Cliente> getAllClientes();
}
