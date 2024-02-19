package com.deveficiente.seeddesafiocdc.controller;

import com.deveficiente.seeddesafiocdc.dto.PaisDTO;
import com.deveficiente.seeddesafiocdc.repository.PaisRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController {

    private final PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public PaisDTO salvar(@Valid @RequestBody PaisDTO dto) {
        var pais = paisRepository.save(dto.toModel());
        return new PaisDTO(pais);
    }
}
