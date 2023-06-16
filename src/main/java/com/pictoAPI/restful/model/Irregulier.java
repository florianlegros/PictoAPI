package com.pictoAPI.restful.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
public class Irregulier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String feminin;
    private String participePasse;
    private String pluriel;

    @OneToMany(mappedBy = "irregulier_id",cascade = CascadeType.ALL)
    private List<Conjugaison> conjugaisons = new ArrayList<>();

    public Irregulier() {
    }

    public Irregulier(String feminin, String participePasse, String pluriel, List<Conjugaison> conjugaisons) {
        this.feminin = feminin;
        this.participePasse = participePasse;
        this.pluriel = pluriel;
        this.conjugaisons = conjugaisons;
    }

    public Irregulier(Long id, String feminin, String participePasse, String pluriel, List<Conjugaison> conjugaisons) {
        this.id = id;
        this.feminin = feminin;
        this.participePasse = participePasse;
        this.pluriel = pluriel;
        this.conjugaisons = conjugaisons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeminin() {
        return feminin;
    }

    public void setFeminin(String feminin) {
        this.feminin = feminin;
    }

    public String getParticipePasse() {
        return participePasse;
    }

    public void setParticipePasse(String participePasse) {
        this.participePasse = participePasse;
    }

    public String getPluriel() {
        return pluriel;
    }

    public void setPluriel(String pluriel) {
        this.pluriel = pluriel;
    }

    public List<Conjugaison> getConjugaisons() {
        return conjugaisons;
    }

    public void setConjugaisons(List<Conjugaison> conjugaisons) {
        this.conjugaisons = conjugaisons;
    }
}
