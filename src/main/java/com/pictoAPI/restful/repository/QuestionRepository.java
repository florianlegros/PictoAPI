package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Question> List<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    <S extends Question> S save(S entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteById(Long aLong);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void delete(Question entity);

    @PreAuthorize("hasRole('MODERATOR')")
    @Override
    void deleteAll();
}