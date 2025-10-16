package com.otavio.clientes.tipo.controller;

import com.otavio.clientes.tipo.dto.TipoDto;
import com.otavio.clientes.tipo.entity.Tipo;
import com.otavio.clientes.tipo.service.TipoService;
import com.otavio.clientes.tipo.service.impl.TipoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
@CrossOrigin("*")
public class TipoController {

    TipoService tipoService;

    TipoController(TipoServiceImpl tipoServiceImpl){
        this.tipoService = tipoServiceImpl;
    }

    @GetMapping("/{id}")
    public TipoDto getTipo(@PathVariable Long id){
        return new TipoDto(tipoService.getTipoById(id));
    }

    @PostMapping
    public TipoDto createTipo(@RequestBody TipoDto tipoDto){
        return new TipoDto(tipoService.createTipo(new Tipo(tipoDto)));
    }

    //method reference
    @GetMapping
    public List<TipoDto> getAll() {
        return tipoService.getAllTipo()
                .stream()
                .map(TipoDto::new)
                .toList();
    }

    @PutMapping("/{id}")
    public TipoDto updateTipo(@RequestBody TipoDto tipoDto, @PathVariable Long id){
        return new TipoDto(tipoService.updateTipo(id, new Tipo(tipoDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteTipo(@PathVariable Long id){
        tipoService.deleteTipo(id);
    }
}
