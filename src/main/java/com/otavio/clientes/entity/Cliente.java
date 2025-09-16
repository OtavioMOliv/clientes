package com.otavio.clientes.entity;

import java.math.BigDecimal;

public class Cliente {

    private String nome;
    private BigDecimal saldo;
    private Boolean ganhaBonus;

    public Cliente(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public Boolean getGanhaBonus() {
        return ganhaBonus;
    }
}
