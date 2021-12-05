package com.ejemplo.tiendaalamano.controller;

import java.util.List;

import com.ejemplo.tiendaalamano.model.CategoriaModel;
import com.ejemplo.tiendaalamano.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/categorias/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String eliminarById(@PathVariable int id) {
        categoriaService.eliminarCategoriaById(id);
        return "La ha eliminado la categoria con de id: " + id;
    }
}
