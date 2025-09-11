package com.otavio.clientes.controller;

import com.otavio.clientes.dto.ClienteDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
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
}
