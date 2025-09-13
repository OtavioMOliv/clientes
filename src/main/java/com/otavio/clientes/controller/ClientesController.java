package com.otavio.clientes.controller;

import com.otavio.clientes.dto.ClienteDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClientesController {

    @GetMapping("/{id}")
    public String getClientes(@PathVariable Long id, @RequestParam(required = false, defaultValue = "false" ) boolean showAllFields){
        if(showAllFields){
            return "o id do cliente eh " + id;
        }
        return "voce passou um id";
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
