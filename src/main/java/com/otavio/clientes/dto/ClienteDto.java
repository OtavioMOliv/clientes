package com.otavio.clientes.dto;

import com.otavio.clientes.entity.Cliente;

public class ClienteDto {
    private String nome;

    public ClienteDto(String nome){
        this.nome = nome;
    }

    public ClienteDto(Cliente cliente){
        this.nome = cliente.getNome();
    }

    public String getNome() {
        return nome;
    }
}
