package com.otavio.clientes.tipo.service;

import com.otavio.clientes.tipo.entity.Tipo;

import java.util.List;

public interface TipoService {
    Tipo getTipoById(Long id);

    Tipo createTipo(Tipo tipo);

    List<Tipo> getAllTipo();

    Tipo updateTipo(Long id, Tipo tipo);

    void deleteTipo(Long id);
}
