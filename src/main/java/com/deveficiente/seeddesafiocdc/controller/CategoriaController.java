package com.deveficiente.seeddesafiocdc.controller;

import com.deveficiente.seeddesafiocdc.dto.CategoriaDTO;
import com.deveficiente.seeddesafiocdc.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public CategoriaDTO salvar(@Valid @RequestBody CategoriaDTO dto) {
        var categoria = categoriaRepository.save(dto.toModel());
        return new CategoriaDTO(categoria);
    }
}
