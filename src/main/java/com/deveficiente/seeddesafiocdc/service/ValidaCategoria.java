package com.deveficiente.seeddesafiocdc.service;

import com.deveficiente.seeddesafiocdc.repository.CategoriaRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidaCategoria implements ConstraintValidator<NomeUnico, String> {

    private final CategoriaRepository categoriaRepository;

    public ValidaCategoria(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return categoriaRepository.findByNome(email).isEmpty();
    }
}
