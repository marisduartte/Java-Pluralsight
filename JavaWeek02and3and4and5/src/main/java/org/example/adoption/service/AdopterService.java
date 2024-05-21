package org.example.adoption.service;

import org.example.adoption.DAO.AdopterDAO;
import org.example.adoption.domain.Adopter;

import java.util.List;

public class AdopterService {

    private AdopterDAO adopterDAO;

    public AdopterService() {
        this.adopterDAO = new AdopterDAO() {
            @Override
            public boolean delete(int id) {
                return false;
            }

            @Override
            public boolean update(Adopter adopter) {
                return false;
            }

            @Override
            public Adopter findById(int id) {
                return null;
            }

            @Override
            public List<Adopter> findAll() {
                return null;
            }
        };
        //this dao new dao
    }

    //add adopter

    public Adopter addAdopter(Adopter adopter){
        Adopter insertedAdopter = this.adopterDAO.insert(adopter);
        return insertedAdopter;
    }

    // get all adopters
    public List<Adopter> getAllAdopters(){
         return this.adopterDAO.getAllAdopters();
    }
}
