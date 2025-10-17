package com.otavio.clientes.cliente.controller;

import com.otavio.clientes.categoria.dto.CategoriaDto;
import com.otavio.clientes.categoria.entity.Categoria;
import com.otavio.clientes.cliente.dto.ClienteDto;
import com.otavio.clientes.cliente.entity.Cliente;
import com.otavio.clientes.cliente.service.ClienteService;
import com.otavio.clientes.cliente.service.impl.ClienteServiceImpl;
import org.springframework.web.bind.annotation.*;

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
        Cliente cliente1 = new Cliente(clienteDto);
        Cliente cliente = clienteService.createCliente(cliente1);
        System.out.println(cliente.getCategoria().getId());
        CategoriaDto categoria = new CategoriaDto();
        categoria.setId(cliente.getCategoria().getId());
        categoria.setNome(cliente.getCategoria().getNome());
        ClienteDto clienteRetorno = new ClienteDto();
        clienteRetorno.setCategoriaDto(categoria);
        clienteRetorno.setNome(cliente.getNome());
        clienteRetorno.setId(cliente.getId());

        return clienteRetorno;
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
