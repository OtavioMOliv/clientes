package com.otavio.clientes.categoria.service;

import com.otavio.clientes.categoria.entity.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria getCategoriaById(Long id);

    Categoria createCategoria(Categoria categoria);

    List<Categoria> getAllCategorias();

    Categoria updateCategoria (Long id, Categoria categoria);

    void  deleteCategoria (Long id);
}
