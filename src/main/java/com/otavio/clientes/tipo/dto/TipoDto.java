package com.otavio.clientes.tipo.dto;

import com.otavio.clientes.tipo.entity.Tipo;

public class TipoDto {
    private Long id;
    private String nome;

    public TipoDto(){}

    public TipoDto(Tipo tipo){
        this.id = tipo.getId();
        this.nome = tipo.getNome();
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
