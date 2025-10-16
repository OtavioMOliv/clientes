package com.otavio.clientes.tipo.entity;

import com.otavio.clientes.tipo.dto.TipoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Tipo(){}

    public Tipo(TipoDto tipoDto) {
        this.id = tipoDto.getId();
        this.nome = tipoDto.getNome();
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
        return "Tipo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

}
