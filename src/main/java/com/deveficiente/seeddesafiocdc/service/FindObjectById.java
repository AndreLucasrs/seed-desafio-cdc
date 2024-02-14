package com.deveficiente.seeddesafiocdc.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class FindObjectById {

    @PersistenceContext
    private EntityManager entityManager;

    public <T> T getById(Class<T> clazz, Long id) {
        return entityManager.find(clazz, id);
    }
}
