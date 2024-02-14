package com.deveficiente.seeddesafiocdc.repository;

import com.deveficiente.seeddesafiocdc.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
