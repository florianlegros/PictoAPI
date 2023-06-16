package com.pictoAPI.restful.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String nom;

    public Tag() {

    }

    public Tag(String nom) {
        this.nom = nom;
    }

    public Tag(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return nom.equals(tag.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}