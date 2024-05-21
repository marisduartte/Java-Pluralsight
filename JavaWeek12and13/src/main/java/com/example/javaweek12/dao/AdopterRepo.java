package com.example.javaweek12.dao;

import com.example.javaweek12.domain.Adopter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdopterRepo extends JpaRepository <Adopter, Long> {
}
