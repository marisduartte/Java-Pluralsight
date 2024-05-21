package org.expd.springbootapp.repository.jpa;

import org.expd.springbootapp.model.Course;
import org.expd.springbootapp.repository.BaseDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
public class JPACouseDAO implements BaseDAO<Course> {
    @Override
    public Course insert(Course object) {
        return null;
    }

    @Override
    public void update(Course object) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Course get(int id) {
        return null;
    }

    @Override
    public List<Course> getAll() {
        return null;
    }

    @Override
    public void clearDatabase() {

    }

    @Override
    public void initDatabase() {

    }
}
