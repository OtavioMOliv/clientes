package com.otavio.clientes.tipo.service.impl;

import com.otavio.clientes.config.exception.ResourceNotFoundException;
import com.otavio.clientes.tipo.entity.Tipo;
import com.otavio.clientes.tipo.repository.TipoRepository;
import com.otavio.clientes.tipo.service.TipoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {
    public static final String ENTITY_NOT_FOUND = "Entidade não encontrada ";
    TipoRepository tipoRepository;

    TipoServiceImpl(TipoRepository tipoRepository){
        this.tipoRepository = tipoRepository;
    }

    @Override
    public Tipo getTipoById(Long id) {
        return tipoRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY_NOT_FOUND + id));
    }

    @Override
    public Tipo createTipo(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    @Override
    public List<Tipo> getAllTipo() {
        return tipoRepository.findAll();
    }

    @Override
    public Tipo updateTipo(Long id, Tipo tipo) {
        tipo.setId(id);
        return  tipoRepository.save(tipo);
    }

    @Override
    public void deleteTipo(Long id) {
         tipoRepository.deleteById(id);
    }
}