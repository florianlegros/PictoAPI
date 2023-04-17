package com.pictoAPI.restful.repository;

import com.pictoAPI.restful.model.Pictogramme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictogrammeRepository extends JpaRepository<Pictogramme, Long> {

}