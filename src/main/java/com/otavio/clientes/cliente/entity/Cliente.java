package com.otavio.clientes.cliente.entity;

import com.otavio.clientes.categoria.dto.CategoriaDto;
import com.otavio.clientes.categoria.entity.Categoria;
import com.otavio.clientes.cliente.dto.ClienteDto;
import jakarta.persistence.*;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    public Cliente(){}

    public Cliente(ClienteDto clienteDto) {
        this.id = clienteDto.getId();
        this.nome = clienteDto.getNome();
        this.categoria = new Categoria(clienteDto.getCategoria());
        if (clienteDto.getCategoria() != null && clienteDto.getCategoria().getId() != null){
            this.categoria = new Categoria();
            this.categoria.setId(clienteDto.getCategoria().getId());
        }
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria=" + (categoria != null ? categoria.getId() : null) +
                '}';
    }
}