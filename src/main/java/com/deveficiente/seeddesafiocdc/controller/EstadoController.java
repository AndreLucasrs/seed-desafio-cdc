package com.deveficiente.seeddesafiocdc.controller;

import com.deveficiente.seeddesafiocdc.dto.EstadoDTO;
import com.deveficiente.seeddesafiocdc.model.Pais;
import com.deveficiente.seeddesafiocdc.repository.EstadoRepository;
import com.deveficiente.seeddesafiocdc.service.FindObjectById;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    private final EstadoRepository estadoRepository;
    private final FindObjectById findObjectById;

    public EstadoController(EstadoRepository estadoRepository, FindObjectById findObjectById) {
        this.estadoRepository = estadoRepository;
        this.findObjectById = findObjectById;
    }

    @PostMapping
    public EstadoDTO salvar(@Valid @RequestBody EstadoDTO dto) {
        var novoEstado = dto.toModel(
                id -> findObjectById.getById(Pais.class, id)
        );
        estadoRepository.save(novoEstado);
        return new EstadoDTO(novoEstado);
    }

}
