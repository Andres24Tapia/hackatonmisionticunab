package com.ejemplo.tiendaalamano.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "promo", indexes = {
    @Index(columnList = "idPromo", unique = true)
})
public class PromoModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPromo;
    
    @Column(name = "outDate")
    private Date outDate;

}
