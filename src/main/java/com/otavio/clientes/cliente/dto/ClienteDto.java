package com.otavio.clientes.cliente.dto;

import com.otavio.clientes.categoria.dto.CategoriaDto;
import com.otavio.clientes.cliente.entity.Cliente;

public class ClienteDto {
    private Long id;
    private String nome;
    private CategoriaDto categoria;

    public ClienteDto(){}

    public ClienteDto(Cliente cliente){
        if (cliente.getCategoria() == null){
            this.categoria = new CategoriaDto();
        }
        this.id = cliente.getId();
        this.nome = cliente.getNome();

    }

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoriaDto(CategoriaDto categoriaDto) {
        this.categoria = categoriaDto;
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
