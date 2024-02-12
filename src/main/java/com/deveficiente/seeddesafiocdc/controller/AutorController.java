package com.deveficiente.seeddesafiocdc.controller;

import com.deveficiente.seeddesafiocdc.dto.AutorDTO;
import com.deveficiente.seeddesafiocdc.repository.AutorRepository;
import com.deveficiente.seeddesafiocdc.service.ValidaEmail;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/autor")
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping
    public AutorDTO salvar(@Valid @RequestBody AutorDTO dto) {
        var autor = autorRepository.save(dto.toModel());
        return new AutorDTO(autor);
    }
}
