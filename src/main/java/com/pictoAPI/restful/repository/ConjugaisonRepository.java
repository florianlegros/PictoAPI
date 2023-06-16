package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.Conjugaison;
import com.pictoAPI.restful.payload.response.ResponsePhrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ConjugaisonRepository extends JpaRepository<Conjugaison, Long> {

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Conjugaison> List<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Conjugaison> S save(S entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteById(Long aLong);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void delete(Conjugaison entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteAll();


}