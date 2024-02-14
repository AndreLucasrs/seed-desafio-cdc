package com.deveficiente.seeddesafiocdc.controller;

import com.deveficiente.seeddesafiocdc.dto.LivroDTO;
import com.deveficiente.seeddesafiocdc.model.Autor;
import com.deveficiente.seeddesafiocdc.model.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager manager;


    @PostMapping
    @Transactional
    public LivroDTO salvar(@Valid @RequestBody LivroDTO dto) {
        var novoLivro = dto.toModel(
                id -> manager.find(Autor.class, id),
                id -> manager.find(Categoria.class, id)
        );
        manager.persist(novoLivro);
        return new LivroDTO(novoLivro);
    }

}
