package com.deveficiente.seeddesafiocdc.repository;

import com.deveficiente.seeddesafiocdc.model.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Long> {

}
