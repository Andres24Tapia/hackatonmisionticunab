package com.ejemplo.tiendaalamano.service;

import java.util.List;

import com.ejemplo.tiendaalamano.model.MarcaModel;
import com.ejemplo.tiendaalamano.repository.IMarcaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaService{

    @Autowired
    private IMarcaRepository marcaRepository;

    public void crearMarca(MarcaModel categoria){
        marcaRepository.save(categoria);
    }


    public List<MarcaModel> obtenerTodo(){
        return marcaRepository.findAll();
    }

    public void eliminarMarcaById(int id) {
        marcaRepository.deleteById(id);
    }
}
