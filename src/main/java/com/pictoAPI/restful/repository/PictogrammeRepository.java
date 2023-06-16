package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.Pictogramme;
import com.pictoAPI.restful.payload.response.ResponsePictogramme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(excerptProjection = ResponsePictogramme.class)
@Repository
public interface PictogrammeRepository extends JpaRepository<Pictogramme, Long> {

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Pictogramme> List<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Pictogramme> S save(S entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteById(Long aLong);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void delete(Pictogramme entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteAll();


}