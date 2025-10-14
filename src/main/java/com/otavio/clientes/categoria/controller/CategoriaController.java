package com.otavio.clientes.categoria.controller;

import com.otavio.clientes.categoria.dto.CategoriaDto;
import com.otavio.clientes.categoria.entity.Categoria;
import com.otavio.clientes.categoria.service.CategoriaService;
import com.otavio.clientes.categoria.service.impl.CategoriaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    CategoriaService categoriaService;

    CategoriaController(CategoriaServiceImpl categoriaServiceImpl){
        this.categoriaService = categoriaServiceImpl;
    }

    @GetMapping("/{id}")
    public CategoriaDto getCategoria(@PathVariable Long id){
        return new CategoriaDto(categoriaService.getCategoriaById(id));
    }

    @PostMapping
    public CategoriaDto createCategoria(@RequestBody CategoriaDto categoriaDto){
        return new CategoriaDto(categoriaService.createCategoria(new Categoria(categoriaDto)));
    }

    //method reference
    @GetMapping
    public List<CategoriaDto> getAll() {
        return categoriaService.getAllCategorias()
                .stream()
                .map(CategoriaDto::new)
                .toList();
    }

    @PutMapping("/{id}")
    public CategoriaDto updateCategoria (@RequestBody CategoriaDto categoriaDto, @PathVariable Long id){
        return new CategoriaDto (categoriaService.updateCategoria(id, new Categoria(categoriaDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria (@PathVariable Long id){
        categoriaService.deleteCategoria(id);
    }
}
