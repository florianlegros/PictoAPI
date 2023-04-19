package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.ERole;
import com.pictoAPI.restful.model.Role;
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
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

    @Override
    void flush();

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role> S saveAndFlush(S entity);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    default void deleteInBatch(Iterable<Role> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAllInBatch(Iterable<Role> entities);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAllInBatch();

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    Role getOne(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    Role getById(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    Role getReferenceById(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role> List<S> findAll(Example<S> example);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role> List<S> findAll(Example<S> example, Sort sort);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    List<Role> findAllById(Iterable<Long> longs);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    Optional<Role> findById(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    boolean existsById(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    long count();

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAll(Iterable<? extends Role> entities);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    List<Role> findAll(Sort sort);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    Page<Role> findAll(Pageable pageable);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role> Optional<S> findOne(Example<S> example);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role> long count(Example<S> example);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role> boolean exists(Example<S> example);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    List<Role> findAll();

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role> List<S> saveAll(Iterable<S> entities);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    <S extends Role> S save(S entity);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteById(Long aLong);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void delete(Role entity);

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    void deleteAll();

}