package org.expd.springbootapp.repository.inmemory;

import org.expd.springbootapp.model.ScheduledClass;
import org.expd.springbootapp.model.Student;
import org.expd.springbootapp.repository.BaseDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("test")
public class ScheduledClassInMemoryDAO implements BaseDAO<ScheduledClass> {

    private static int nextId;
    private Map<Integer, ScheduledClass> classes = new HashMap<Integer, ScheduledClass>();
    @Override
    public ScheduledClass insert(ScheduledClass sClass) {
        sClass.setId(nextId++);
        this.classes.put(sClass.getId(), sClass);
        return sClass;
    }

    @Override
    public void update(ScheduledClass sClass) {
        this.classes.put(sClass.getId(), sClass);
    }

    @Override
    public void delete(int id) {
        this.classes.remove(id);
    }

    @Override
    public ScheduledClass get(int id) {
        return this.classes.get(id);
    }

    @Override
    public List<ScheduledClass> getAll() {
        return this.classes.values().stream().toList();
    }

    @Override
    public void clearDatabase() {
        this.classes = null;
    }

    @Override
    public void initDatabase() {
        this.classes = new HashMap<Integer, ScheduledClass>();
        nextId = 0;
    }
}
