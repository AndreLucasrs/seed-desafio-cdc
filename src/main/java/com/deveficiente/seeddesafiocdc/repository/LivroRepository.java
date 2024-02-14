package com.deveficiente.seeddesafiocdc.repository;

import com.deveficiente.seeddesafiocdc.model.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

}
