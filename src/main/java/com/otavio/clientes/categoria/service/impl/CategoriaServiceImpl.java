package com.otavio.clientes.categoria.service.impl;

import com.otavio.clientes.config.exception.ResourceNotFoundException;
import com.otavio.clientes.categoria.entity.Categoria;
import com.otavio.clientes.categoria.repository.CategoriaRepository;
import com.otavio.clientes.categoria.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    public static final String ENTITY_NOT_FOUND = "Entidade não encontrada ";
    CategoriaRepository categoriaRepository;

    CategoriaServiceImpl(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY_NOT_FOUND + id));
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria updateCategoria(Long id, Categoria categoria) {
        categoria.setId(id);
        return  categoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoria(Long id) {
         categoriaRepository.deleteById(id);
    }
}