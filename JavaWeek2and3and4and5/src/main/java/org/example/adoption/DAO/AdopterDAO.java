package org.example.adoption.DAO;

import org.example.adoption.domain.Adopter;

import java.util.ArrayList;
import java.util.List;

public abstract class AdopterDAO {

    List<Adopter> adopterList = new ArrayList<>();

    public Adopter insert(Adopter adopter){
        this.adopterList.add(adopter);
        return adopter;
    }

    public List<Adopter> getAllAdopters(){
        return this.adopterList;
    }

    public abstract boolean delete(int id);

    public abstract boolean update(Adopter adopter);

    public abstract Adopter findById(int id);

    public abstract List<Adopter> findAll();
}
