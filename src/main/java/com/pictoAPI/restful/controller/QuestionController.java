package com.pictoAPI.restful.controller;

import com.pictoAPI.restful.model.Question;
import com.pictoAPI.restful.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionRepository repository;

    @GetMapping("/all")
    public List<Question> getAll() {
        return repository.findAll();
    }
    @PreAuthorize("hasRole('MODERATOR')")
    @PostMapping("/add")
    public Question newQuestion(@RequestBody Question newQuestion) {
        return repository.save(newQuestion);
    }

    @GetMapping("/{id}")
    public Optional<Question> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @PutMapping("/{id}")
    public Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {
        newQuestion.setId(id);
        return repository.save(newQuestion);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        repository.deleteById(id);
    }
}