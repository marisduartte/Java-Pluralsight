package com.example.javaweek12.dao;

import com.example.javaweek12.domain.Adopter;
import com.example.javaweek12.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends JpaRepository<Pet, Long> {

}
