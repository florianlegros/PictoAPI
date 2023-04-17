package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.ERole;
import com.pictoAPI.restful.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}