package com.otavio.clientes.controller;

import com.otavio.clientes.dto.ClienteDto;
import com.otavio.clientes.entity.Cliente;
import com.otavio.clientes.service.ClienteService;
import com.otavio.clientes.service.impl.ClienteServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    ClienteService clienteService;

    ClienteController(ClienteServiceImpl clienteServiceImpl){
        this.clienteService = clienteServiceImpl;
    }

    @GetMapping("/{id}")
    public ClienteDto getCliente(@PathVariable Long id){
        return new ClienteDto(clienteService.getClienteById(id));
    }

    @PostMapping
    public ClienteDto createCliente(@RequestBody ClienteDto clienteDto){
        return new ClienteDto(clienteService.createCliente(new Cliente(clienteDto)));
    }

    //method reference
    @GetMapping
    public List<ClienteDto> getAll() {
        return clienteService.getAllClientes()
                .stream()
                .map(ClienteDto::new)
                .toList();
    }

    @PutMapping("/{id}")
    public ClienteDto updateCliente (@RequestBody ClienteDto clienteDto, @PathVariable Long id){
        return new ClienteDto (clienteService.updateCliente(id, new Cliente(clienteDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteCliente (@PathVariable Long id){
        clienteService.deleteCliente(id);
    }
}
