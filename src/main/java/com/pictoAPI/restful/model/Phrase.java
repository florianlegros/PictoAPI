package com.pictoAPI.restful.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Phrase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String audio;
    private int score;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @JoinColumn(name = "question_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Question.class, fetch = FetchType.LAZY)
    private Question question;
    @Column(name = "question_id")
    private Long questionId;

    @ManyToMany()
    @JoinTable(name = "phrase_pictogramme",
            joinColumns = @JoinColumn(name = "phrase_id"),
            inverseJoinColumns = @JoinColumn(name = "pictogramme_id"))
    private List<Pictogramme> pictogrammes = new ArrayList<>();

    public Phrase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question getQuestion() {
        return question;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(Question question) {
        this.question = question;
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