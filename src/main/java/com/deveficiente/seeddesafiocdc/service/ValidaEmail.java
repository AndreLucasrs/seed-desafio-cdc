package com.deveficiente.seeddesafiocdc.service;

import com.deveficiente.seeddesafiocdc.repository.AutorRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidaEmail implements ConstraintValidator<EmailUnico, String> {

    private final AutorRepository autorRepository;

    public ValidaEmail(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return autorRepository.findByEmail(email).isEmpty();
    }
}
