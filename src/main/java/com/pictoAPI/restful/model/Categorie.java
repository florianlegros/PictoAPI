package com.pictoAPI.restful.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.util.*;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String nom;
    @NotBlank
    private String imgfile;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @OneToMany(mappedBy = "categorieId")
    private List<Pictogramme> pictogrammes = new ArrayList<>();

    public Categorie() {
    }

    public Categorie(String nom, String imgfile) {
        this.nom = nom;
        this.imgfile = imgfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImgfile() {
        return imgfile;
    }

    public void setImgfile(String imgfile) {
        this.imgfile = imgfile;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Pictogramme> getPictogrammes() {
        return pictogrammes;
    }

    public void setPictogrammes(List<Pictogramme> pictogrammes) {
        this.pictogrammes = pictogrammes;
    }
}