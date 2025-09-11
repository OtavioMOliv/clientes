package com.otavio.clientes.dto;

public class ClienteDto {
    private String nome;

    ClienteDto(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
