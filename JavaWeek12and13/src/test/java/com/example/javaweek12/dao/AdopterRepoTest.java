package com.example.javaweek12.dao;

import com.example.javaweek12.domain.Adopter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdopterRepoTest {

    @Autowired
    AdopterRepo adopterRepo;

    @Test
    public void testFindAll(){
        List<Adopter> all = adopterRepo.findAll();
        Assertions.assertNotNull(all);
    }
}
