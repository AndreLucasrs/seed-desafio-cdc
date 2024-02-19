package com.deveficiente.seeddesafiocdc.controller;

import com.deveficiente.seeddesafiocdc.dto.InfoLivroDTO;
import com.deveficiente.seeddesafiocdc.dto.LivroDTO;
import com.deveficiente.seeddesafiocdc.model.Autor;
import com.deveficiente.seeddesafiocdc.model.Categoria;
import com.deveficiente.seeddesafiocdc.model.Livro;
import com.deveficiente.seeddesafiocdc.repository.LivroRepository;
import com.deveficiente.seeddesafiocdc.service.FindObjectById;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final FindObjectById findObjectById;
    private final LivroRepository livroRepository;

    public LivroController(FindObjectById findObjectById, LivroRepository livroRepository) {
        this.findObjectById = findObjectById;
        this.livroRepository = livroRepository;
    }

    @PostMapping
    public LivroDTO salvar(@Valid @RequestBody LivroDTO dto) {
        var novoLivro = dto.toModel(
                id -> findObjectById.getById(Autor.class, id),
                id -> findObjectById.getById(Categoria.class, id)
        );
        livroRepository.save(novoLivro);
        return new LivroDTO(novoLivro);
    }

    @GetMapping
    public List<InfoLivroDTO> buscar() {
        var livros = new ArrayList<Livro>();
        livroRepository.findAll().forEach(livros::add);
        return livros.stream().map(InfoLivroDTO::new).toList();
    }

    @GetMapping("/{id}")
    public LivroDTO livroDTO(@PathVariable Long id) {
        var livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new LivroDTO(livro);
    }

}
