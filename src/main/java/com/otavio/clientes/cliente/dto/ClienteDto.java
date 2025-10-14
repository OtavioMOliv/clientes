package com.otavio.clientes.cliente.dto;

import com.otavio.clientes.cliente.entity.Cliente;

public class ClienteDto {
    private Long id;
    private String nome;

    public ClienteDto(){}

    public ClienteDto(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
