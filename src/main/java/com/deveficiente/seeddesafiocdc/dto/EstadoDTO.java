package com.deveficiente.seeddesafiocdc.dto;

import com.deveficiente.seeddesafiocdc.model.Estado;
import com.deveficiente.seeddesafiocdc.model.Pais;
import com.deveficiente.seeddesafiocdc.service.ExistsId;
import com.deveficiente.seeddesafiocdc.service.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.function.Function;

public class EstadoDTO {

    private Long id;
    @NotBlank
    @UniqueValue(fieldName = "nome", domainClass = Estado.class, message = "Nome de estado ja existe")
    private String nome;

    @NotNull
    @ExistsId(fieldName = "id", domainClass = Pais.class, message = "Nao existe esse pais")
    private Long idPais;

    public EstadoDTO() {
    }

    public EstadoDTO(Estado model) {
        this.id = model.getId();
        this.nome = model.getNome();
        this.idPais = model.getPais().getId();
    }

    public Estado toModel(Function<Long, Pais> carregaPais) {

        Pais pais = carregaPais.apply(idPais);

        return new Estado(nome, pais);
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

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }
}
