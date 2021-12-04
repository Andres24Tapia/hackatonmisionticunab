package com.ejemplo.tiendaalamano.service;

import java.util.List;
import java.util.Optional;

import com.ejemplo.tiendaalamano.exception.BadResourceRequestException;
import com.ejemplo.tiendaalamano.model.CategoriaModel;
import com.ejemplo.tiendaalamano.repository.ICategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    
    @Autowired
    private ICategoriaRepository categoriaRepository;

    public void crearCategoria(CategoriaModel categoria){
        categoriaRepository.save(categoria);
    }


    public List<CategoriaModel> obtenerTodo(){
        return categoriaRepository.findAll();
    }
}
