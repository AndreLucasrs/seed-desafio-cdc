package com.deveficiente.seeddesafiocdc.dto;

import com.deveficiente.seeddesafiocdc.model.Categoria;
import com.deveficiente.seeddesafiocdc.service.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {

    private Long id;
    @NotBlank
    @UniqueValue(fieldName = "nome", domainClass = Categoria.class, message = "Nome de categoria ja existe")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria model) {
        this.id = model.getId();
        this.nome = model.getNome();
    }

    public Categoria toModel() {
        var model = new Categoria();
        model.setNome(nome);
        return model;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
