package com.pictoAPI.restful.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String contenu;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_categorie", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "categorie_id"))
    private List<Categorie> categories = new ArrayList<>();
    @OneToMany(mappedBy = "question")
    @Transient
    private List<Phrase> phrases;

    public Question() {
    }

    public Question(String contenu) {
        this.contenu = contenu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createAt) {
        this.createdAt = createAt;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}