package com.ejemplo.tiendaalamano.controller;

import java.util.List;


import com.ejemplo.tiendaalamano.model.MarcaModel;
import com.ejemplo.tiendaalamano.service.MarcaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MarcaControler {
    @Autowired
    MarcaService marcaService;

    @GetMapping("/marcas")
    public List<MarcaModel> obtMarcaModel(){
        return marcaService.obtenerTodo();
    }

    @PostMapping(value = "/marca", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void crearMarca(@RequestBody @Validated MarcaModel nuevaMarca) {
        marcaService.crearMarca(nuevaMarca);
    }

    @RequestMapping(value = "/marcas/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String eliminarById(@PathVariable int id) {
        marcaService.eliminarMarcaById(id);
        return "La ha eliminado la categoria con de id: " + id;
    }
}
