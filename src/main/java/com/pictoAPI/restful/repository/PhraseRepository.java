package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.Phrase;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@PreAuthorize("hasRole('USER')")
@Repository
public interface PhraseRepository extends JpaRepository<Phrase, Long> {
    @Override
    void flush();

    @Override
    <S extends Phrase> S saveAndFlush(S entity);

    @Override
    <S extends Phrase> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<Phrase> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<Phrase> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    Phrase getOne(Long aLong);

    @Override
    Phrase getById(Long aLong);

    @Override
    Phrase getReferenceById(Long aLong);

    @Override
    <S extends Phrase> List<S> findAll(Example<S> example);

    @Override
    <S extends Phrase> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends Phrase> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Phrase> findAll();

    @Override
    List<Phrase> findAllById(Iterable<Long> longs);

    @Override
    <S extends Phrase> S save(S entity);

    @Override
    Optional<Phrase> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Phrase entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends Phrase> entities);

    @Override
    void deleteAll();

    @Override
    List<Phrase> findAll(Sort sort);

    @Override
    Page<Phrase> findAll(Pageable pageable);

    @Override
    <S extends Phrase> Optional<S> findOne(Example<S> example);

    @Override
    <S extends Phrase> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends Phrase> long count(Example<S> example);

    @Override
    <S extends Phrase> boolean exists(Example<S> example);

    @Override
    <S extends Phrase, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}