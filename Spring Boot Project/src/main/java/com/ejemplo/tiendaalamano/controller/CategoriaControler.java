package com.ejemplo.tiendaalamano.controller;

import java.util.List;

import com.ejemplo.tiendaalamano.model.CategoriaModel;
import com.ejemplo.tiendaalamano.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoriaControler {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<CategoriaModel> obtCategorias(){
        return categoriaService.obtenerTodo();
    }

    @PostMapping(value = "/categoria", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void crearCategoria(@RequestBody @Validated CategoriaModel newCategoria) {
        categoriaService.crearCategoria(newCategoria);
    }
}
