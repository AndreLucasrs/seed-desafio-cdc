package com.deveficiente.seeddesafiocdc.dto;

import com.deveficiente.seeddesafiocdc.model.Autor;
import com.deveficiente.seeddesafiocdc.model.Categoria;
import com.deveficiente.seeddesafiocdc.model.Livro;
import com.deveficiente.seeddesafiocdc.service.ExistsId;
import com.deveficiente.seeddesafiocdc.service.UniqueValue;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class LivroDTO {

    private Long id;

    @NotBlank
    @UniqueValue(fieldName = "titulo", domainClass = Livro.class, message = "Ja existe titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(value = 20)
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private Integer numeroPaginas;

    @NotBlank
    @UniqueValue(fieldName = "isbn", domainClass = Livro.class, message = "Ja existe isbn")
    private String isbn;

    @NotNull
    @Future
    private LocalDateTime lancar;

    @ExistsId(fieldName = "id", domainClass = Categoria.class, message = "Nao existe essa categoria")
    @NotNull
    private Long categoriaId;

    @ExistsId(fieldName = "id", domainClass = Autor.class, message = "Nao existe esse autor")
    @NotNull
    private Long autorId;

    public LivroDTO() {
    }

    public LivroDTO(Livro model) {
        this.id = model.getId();
        this.categoriaId = model.getCategoria().getId();
        this.autorId = model.getAutor().getId();
        this.titulo = model.getTitulo();
        this.resumo = model.getResumo();
        this.sumario = model.getSumario();
        this.preco = model.getPreco();
        this.numeroPaginas = model.getNumeroPaginas();
        this.isbn = model.getIsbn();
        this.lancar = model.getLancar();
    }

    public Livro toModel(Function<Long, Autor> carregaAutor,
                         Function<Long, Categoria> carregaCategoria) {

        Autor autor = carregaAutor.apply(autorId);
        Categoria categoria = carregaCategoria.apply(categoriaId);

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn,
                lancar, categoria, autor);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getLancar() {
        return lancar;
    }

    public void setLancar(LocalDateTime lancar) {
        this.lancar = lancar;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
}
