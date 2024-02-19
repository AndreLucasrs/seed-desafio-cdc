package com.deveficiente.seeddesafiocdc.dto;

import com.deveficiente.seeddesafiocdc.model.Pais;
import com.deveficiente.seeddesafiocdc.service.UniqueValue;
import jakarta.validation.constraints.NotBlank;

public class PaisDTO {

    private Long id;
    @NotBlank
    @UniqueValue(fieldName = "nome", domainClass = Pais.class, message = "Nome de pais ja existe")
    private String nome;

    public PaisDTO() {
    }

    public PaisDTO(Pais model) {
        this.id = model.getId();
        this.nome = model.getNome();
    }

    public Pais toModel() {
        return new Pais(nome);
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
