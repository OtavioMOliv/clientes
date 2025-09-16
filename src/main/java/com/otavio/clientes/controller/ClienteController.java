package com.otavio.clientes.controller;

import com.otavio.clientes.dto.ClienteDto;
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
    public String createCliente(@RequestBody ClienteDto clienteDto){
        return "Cliente enviado " + clienteDto.getNome();
    }

    @GetMapping
    public List<ClienteDto> getAll(){
        ArrayList<ClienteDto> clientes = new ArrayList<>();
        clientes.add(new ClienteDto("Andre"));
        clientes.add(new ClienteDto("Otavio"));
        return clientes;
    }
}
