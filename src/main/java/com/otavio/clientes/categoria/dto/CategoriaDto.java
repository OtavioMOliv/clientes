package com.otavio.clientes.categoria.dto;

import com.otavio.clientes.categoria.entity.Categoria;

public class CategoriaDto {
    private Long id;
    private String nome;

    public CategoriaDto(){}

    public CategoriaDto(Categoria categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
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
