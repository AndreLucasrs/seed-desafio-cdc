package com.deveficiente.seeddesafiocdc.service;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidaEmail.class)
public @interface EmailUnico {

    String message() default "Ja existe email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
