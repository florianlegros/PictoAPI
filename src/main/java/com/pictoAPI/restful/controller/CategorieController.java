package com.pictoAPI.restful.controller;

import com.pictoAPI.restful.model.Categorie;
import com.pictoAPI.restful.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/categories")
public class CategorieController {
    @Autowired
    private CategorieRepository repository;

    @GetMapping("/all")
    public List<Categorie> getAll() {
        return repository.findAll();
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @PostMapping("/add")
    public Categorie newCategorie(@RequestBody Categorie newCategorie) {
        return repository.save(newCategorie);
    }

    @GetMapping("/{id}")
    public Optional<Categorie> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @PutMapping("/{id}")
    public Categorie replaceCategorie(@RequestBody Categorie newCategorie, @PathVariable Long id) {
        newCategorie.setId(id);
        return repository.save(newCategorie);
    }

    @PreAuthorize("hasRole('MODERATOR')")
    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        repository.deleteById(id);
    }
}