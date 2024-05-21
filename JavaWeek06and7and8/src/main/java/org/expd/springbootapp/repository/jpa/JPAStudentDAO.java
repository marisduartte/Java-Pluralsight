package org.expd.springbootapp.repository.jpa;

import org.expd.springbootapp.model.Student;
import org.expd.springbootapp.repository.BaseDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
public class JPAStudentDAO implements BaseDAO<Student> {

    @Override
    public Student insert(Student object) {
        return null;
    }

    @Override
    public void update(Student object) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Student get(int id) {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public void clearDatabase() {

    }

    @Override
    public void initDatabase() {

    }
}
