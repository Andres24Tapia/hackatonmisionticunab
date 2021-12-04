package com.ejemplo.tiendaalamano.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;



@Entity
@Table(name = "categoria", indexes = {
    @Index(columnList = "id_categoria", unique = true)
})
public class CategoriaModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_categoria;
    
    @Column(name = "nombre")
    private String nombre;

    public CategoriaModel() {
    }

    public CategoriaModel(int idCategoria, String nombre) {
        this.id_categoria = idCategoria;
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
