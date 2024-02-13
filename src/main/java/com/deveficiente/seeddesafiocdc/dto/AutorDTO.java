package com.deveficiente.seeddesafiocdc.dto;

import com.deveficiente.seeddesafiocdc.model.Autor;
import com.deveficiente.seeddesafiocdc.service.UniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class AutorDTO {

    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    @UniqueValue(fieldName = "email", domainClass = Autor.class, message = "Ja existe email")
    private String email;

    @Size(max = 400)
    @NotBlank
    private String descricao;

    private LocalDateTime created;

    public AutorDTO() {
    }

    public AutorDTO(Autor model) {
        this.nome = model.getNome();
        this.email = model.getEmail();
        this.descricao = model.getDescricao();
        this.created = model.getCreated();
        this.id = model.getId();
    }

    public Autor toModel() {
        var model = new Autor();
        model.setDescricao(descricao);
        model.setEmail(email);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getCreated() {
        return created;
    }

}
