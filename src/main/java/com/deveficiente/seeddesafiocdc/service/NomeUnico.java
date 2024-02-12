package com.deveficiente.seeddesafiocdc.service;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidaCategoria.class)
public @interface NomeUnico {

    String message() default "Nome de categoria ja existe";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
