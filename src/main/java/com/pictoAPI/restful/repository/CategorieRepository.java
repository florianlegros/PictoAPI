package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Categorie> List<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Categorie> S save(S entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteById(Long aLong);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void delete(Categorie entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteAll();
}