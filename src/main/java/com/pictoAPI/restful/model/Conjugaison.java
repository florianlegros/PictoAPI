package com.pictoAPI.restful.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
public class Conjugaison {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String temps;
    @Column(name = "irregulier_id")
    private Long irregulier_id;
    private String premiere_pers_sing;
    private String deuxieme_pers_sing;
    private String troisieme_pers_sing;
    private String premiere_pers_pluriel;
    private String deuxieme_pers_pluriel;
    private String troisieme_pers_pluriel;

    public Conjugaison() {
    }

    public Conjugaison(String temps, String premiere_pers_sing, String deuxieme_pers_sing, String troisieme_pers_sing, String premiere_pers_pluriel, String deuxieme_pers_pluriel, String troisieme_pers_pluriel) {
        this.temps = temps;
        this.premiere_pers_sing = premiere_pers_sing;
        this.deuxieme_pers_sing = deuxieme_pers_sing;
        this.troisieme_pers_sing = troisieme_pers_sing;
        this.premiere_pers_pluriel = premiere_pers_pluriel;
        this.deuxieme_pers_pluriel = deuxieme_pers_pluriel;
        this.troisieme_pers_pluriel = troisieme_pers_pluriel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public String getPremiere_pers_sing() {
        return premiere_pers_sing;
    }

    public void setPremiere_pers_sing(String premiere_pers_sing) {
        this.premiere_pers_sing = premiere_pers_sing;
    }

    public String getDeuxieme_pers_sing() {
        return deuxieme_pers_sing;
    }

    public void setDeuxieme_pers_sing(String deuxieme_pers_sing) {
        this.deuxieme_pers_sing = deuxieme_pers_sing;
    }

    public String getTroisieme_pers_sing() {
        return troisieme_pers_sing;
    }

    public void setTroisieme_pers_sing(String troisieme_pers_sing) {
        this.troisieme_pers_sing = troisieme_pers_sing;
    }

    public String getPremiere_pers_pluriel() {
        return premiere_pers_pluriel;
    }

    public void setPremiere_pers_pluriel(String premiere_pers_pluriel) {
        this.premiere_pers_pluriel = premiere_pers_pluriel;
    }

    public String getDeuxieme_pers_pluriel() {
        return deuxieme_pers_pluriel;
    }

    public void setDeuxieme_pers_pluriel(String deuxieme_pers_pluriel) {
        this.deuxieme_pers_pluriel = deuxieme_pers_pluriel;
    }

    public String getTroisieme_pers_pluriel() {
        return troisieme_pers_pluriel;
    }

    public void setTroisieme_pers_pluriel(String troisieme_pers_pluriel) {
        this.troisieme_pers_pluriel = troisieme_pers_pluriel;
    }
}
