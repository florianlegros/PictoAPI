package com.pictoAPI.restful.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
public class Pictogramme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @NotBlank
    private String nom;
    @NotBlank
    private String imgfile;
    @UpdateTimestamp
    private Date updatedAt;
    @Column(name = "categorie_id")
    private Long categorieId;
    @Column(name = "sous_categorie_id")
    private Long sousCategorieId;
    @OneToOne
    private Irregulier irregulier;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pictogramme_tag", joinColumns = @JoinColumn(name = "pictogramme_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();
    public Pictogramme() {
    }

    public Pictogramme(String nom, String imgfile) {
        this.nom = nom;
        this.imgfile = imgfile;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Irregulier getIrregulier() {
        return irregulier;
    }

    public void setIrregulier(Irregulier irregulier) {
        this.irregulier = irregulier;
    }

    public Long getSousCategorieId() {
        return sousCategorieId;
    }

    public void setSousCategorieId(Long sousCategorieId) {
        this.sousCategorieId = sousCategorieId;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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


    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }
}