package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.User;
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

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Override
    void flush();

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> S saveAndFlush(S entity);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> List<S> saveAllAndFlush(Iterable<S> entities);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    default void deleteInBatch(Iterable<User> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAllInBatch(Iterable<User> entities);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAllInBatch();

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    User getOne(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    User getById(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    User getReferenceById(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    Optional<User> findById(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAll(Iterable<? extends User> entities);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    Page<User> findAll(Pageable pageable);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> Optional<S> findOne(Example<S> example);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> Page<S> findAll(Example<S> example, Pageable pageable);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> long count(Example<S> example);

    @Override
    <S extends User> boolean exists(Example<S> example);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    List<User> findAll(Sort sort);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    List<User> findAllById(Iterable<Long> longs);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> List<S> findAll(Example<S> example, Sort sort);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> List<S> findAll(Example<S> example);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    List<User> findAll();

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> List<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends User> S save(S entity);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteById(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void delete(User entity);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAll();
}