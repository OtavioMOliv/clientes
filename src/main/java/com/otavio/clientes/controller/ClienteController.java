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

    @GetMapping("/fors")
    public List<ClienteDto> getAllFors(){

        List<ClienteDto> clientesDto = new ArrayList<>();

        List<Cliente> clientes = new ArrayList<>();
        clientes = clienteService.getAllClientes();
        System.out.println("Cliente Entidade " + clientes.size());

        for(int i=0; i<clientes.size(); i++){
            Cliente cliente = clientes.get(i);
            clientesDto.add(new ClienteDto(cliente));
        }

        for(Cliente c : clientes){
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setId(c.getId());
            clienteDto.setNome(c.getNome());
            clientesDto.add(clienteDto);
        }


        for(Cliente c : clientes){
            clientesDto.add(new ClienteDto(c));
        }

        clientes.stream().forEach(c ->{ clientesDto.add(new ClienteDto(c));});

        //lambda
        clientes.stream().forEach(c -> clientesDto.add(new ClienteDto(c)));

        clientes.forEach(c -> clientesDto.add(new ClienteDto(c)));

        System.out.println("Cliente DTO " + clientesDto.size());

        return clientesDto;
    }
}
