package com.deveficiente.seeddesafiocdc.repository;

import com.deveficiente.seeddesafiocdc.model.Estado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long> {

}
