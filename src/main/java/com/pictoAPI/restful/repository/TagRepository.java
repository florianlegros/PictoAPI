package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Tag> List<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Tag> S save(S entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteById(Long aLong);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void delete(Tag entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteAll();


}