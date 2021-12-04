package com.ejemplo.tiendaalamano.repository;

import com.ejemplo.tiendaalamano.model.MarcaModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaRepository  extends JpaRepository<MarcaModel, Integer>{
    
}
