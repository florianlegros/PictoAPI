package com.pictoAPI.restful.controller;

import com.pictoAPI.restful.model.Pictogramme;
import com.pictoAPI.restful.repository.PictogrammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/pictogrammes")
public class PictogrammeController {

    @Autowired
    private PictogrammeRepository repository;

    @GetMapping("/all")
    public List<Pictogramme> getAll() {
        return repository.findAll();
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR')")
    public Pictogramme newPicto(@RequestBody Pictogramme newPicto) {
        return repository.save(newPicto);
    }

    @GetMapping("/get/{id}")
    public Optional<Pictogramme> one(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/get/{id}/categorie/{idCategorie}")
    @PreAuthorize("hasRole('MODERATOR')")
    public Pictogramme setCategorie(@RequestBody Pictogramme newPicto, @PathVariable Long id, @PathVariable Long idCategorie) {
        newPicto.setId(id);
        newPicto.setCategorieId(idCategorie);
        return repository.save(newPicto);
    }

    @PutMapping("/change/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public Pictogramme replacePicto(@RequestBody Pictogramme newPicto, @PathVariable Long id) {
        newPicto.setId(id);
        return repository.save(newPicto);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public void deletePicto(@PathVariable Long id) {
        repository.deleteById(id);
    }
}