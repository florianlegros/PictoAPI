package com.pictoAPI.restful.controller;

import com.pictoAPI.restful.model.Pictogramme;
import com.pictoAPI.restful.repository.PictogrammeRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/pictogramme")
public class PictogrammeController {

    private final PictogrammeRepository repository;
    public PictogrammeController(PictogrammeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/all")
    public List<Pictogramme> getAll() {
        return repository.findAll();
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('MODERATOR')")
    public Pictogramme newPicto(@RequestBody Pictogramme newPicto) {
        return repository.save(newPicto);
    }

    @GetMapping("/{id}")
    public Optional<Pictogramme> one(@PathVariable Long id) {
        return repository.findById(id);
    }
    @PostMapping("/{id}/categorie/{idCategorie}")
    @PreAuthorize("hasRole('MODERATOR')")
    public Pictogramme setCategorie(@RequestBody Pictogramme newPicto,@PathVariable Long id,@PathVariable Long idCategorie) {
        newPicto.setId(id);
        newPicto.setCategorieId(idCategorie);
        return repository.save(newPicto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public Pictogramme replacePicto(@RequestBody Pictogramme newPicto, @PathVariable Long id) {
        newPicto.setId(id);
        return repository.save(newPicto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public void deletePicto(@PathVariable Long id) {
        repository.deleteById(id);
    }
}