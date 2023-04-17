package com.pictoAPI.restful.controller;

import com.pictoAPI.restful.repository.QuestionRepository;
import com.pictoAPI.restful.model.Question;
import com.pictoAPI.restful.repository.PictogrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('MODERATOR')")
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionRepository repository;
    @Autowired
    private PictogrammeRepository pictorepository;


    @GetMapping("/all")
    public List<Question> getAll() {
        return repository.findAll();
    }
    @PostMapping("/add")
    public Question newQuestion(@RequestBody Question newQuestion) {
        return repository.save(newQuestion);
    }

    @GetMapping("/{id}")
    public Optional<Question> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {
        newQuestion.setId(id);
        return repository.save(newQuestion);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        repository.deleteById(id);
    }
}