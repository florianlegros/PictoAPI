package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.Irregulier;
import com.pictoAPI.restful.payload.response.ResponseIrregulier;
import com.pictoAPI.restful.payload.response.ResponsePhrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;
@RepositoryRestResource(excerptProjection = ResponseIrregulier.class)
@Repository
public interface IrregulierRepository extends JpaRepository<Irregulier, Long> {

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Irregulier> List<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Irregulier> S save(S entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteById(Long aLong);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void delete(Irregulier entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteAll();


}