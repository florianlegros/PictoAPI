package com.pictoAPI.restful.controller;

import com.pictoAPI.restful.model.Phrase;
import com.pictoAPI.restful.repository.PhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("hasRole('MODERATOR')")
@RequestMapping("/api/phrase")
public class PhraseController {

    //une requete pour recuperer la liste de phrases d'un patient findByUserId -> List<phrase(id,contenu,question)>
   
   
    @Autowired
    private PhraseRepository repository;



    @GetMapping("/all")
    public List<Phrase> getAll() {
        return repository.findAll();
    }
    @PostMapping("/add")
    public Phrase newPhrase(@RequestBody Phrase newPhrase) {
        return repository.save(newPhrase);
    }

    @GetMapping("/{id}")
    public Optional<Phrase> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public Phrase replacePhrase(@RequestBody Phrase newPhrase, @PathVariable Long id) {
        newPhrase.setId(id);
        return repository.save(newPhrase);
    }

    @DeleteMapping("/{id}")
    public void deletePhrase(@PathVariable Long id) {
        repository.deleteById(id);
    }


}