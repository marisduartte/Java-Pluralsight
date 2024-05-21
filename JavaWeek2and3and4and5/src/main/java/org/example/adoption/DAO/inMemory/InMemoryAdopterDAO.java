package org.example.adoption.DAO.inMemory;
import org.example.adoption.DAO.AdopterDAO;
import org.example.adoption.domain.Adopter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryAdopterDAO extends AdopterDAO {

    public InMemoryAdopterDAO() {
        int stop = 1;
    }

    private Map<Integer, Adopter> adopters = new HashMap<>();
    private int nextId = 1;

    @Override
    public Adopter insert(Adopter adopter) {
        int id = nextId++;
        adopter.setId(id);
        adopter.setAdopterName("InMem: " + adopter.getAdopterName());

        adopters.put(adopter.getId(), adopter);
        return adopter;
    }

    @Override
    public boolean delete(int id) {
        return adopters.remove(id) != null;
    }

    @Override
    public boolean update(Adopter adopter) {
        return adopters.replace(adopter.getId(), adopter) != null;
    }

    @Override
    public Adopter findById(int id) {
        return adopters.get(id);
    }

    @Override
    public List<Adopter> findAll() {
        return new ArrayList<>(adopters.values());
    }

}
