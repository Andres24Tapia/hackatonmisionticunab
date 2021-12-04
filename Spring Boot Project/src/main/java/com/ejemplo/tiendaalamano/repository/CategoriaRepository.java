package com.ejemplo.tiendaalamano.repository;

import com.ejemplo.tiendaalamano.model.CategoriaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer>{
    
}
