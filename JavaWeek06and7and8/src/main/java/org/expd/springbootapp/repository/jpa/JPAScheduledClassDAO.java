package org.expd.springbootapp.repository.jpa;

import org.expd.springbootapp.model.ScheduledClass;
import org.expd.springbootapp.repository.BaseDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Profile("prod")
public class JPAScheduledClassDAO implements BaseDAO<ScheduledClass> {

    private static int nextId;
    private Map<Integer, ScheduledClass> scheduledClasses = new HashMap<>();

    @Override
    public ScheduledClass insert(ScheduledClass scheduledClass) {
        scheduledClass.setId(nextId++);
        this.scheduledClasses.put(scheduledClass.getId(), scheduledClass);
        return scheduledClass;
    }

    @Override
    public void update(ScheduledClass scheduledClass) {
        this.scheduledClasses.put(scheduledClass.getId(),scheduledClass);
    }

    @Override
    public void delete(int id) {
        this.scheduledClasses.remove(id);
    }

    @Override
    public ScheduledClass get(int id) {
        return this.scheduledClasses.get(id);
    }

    @Override
    public List<ScheduledClass> getAll() {
        return this.scheduledClasses.values().stream().toList();
    }

    @Override
    public void clearDatabase() {
        this.scheduledClasses = null;
    }

    @Override
    public void initDatabase() {
        this.scheduledClasses = new HashMap<Integer, ScheduledClass>();
        nextId = 0;
    }
}
