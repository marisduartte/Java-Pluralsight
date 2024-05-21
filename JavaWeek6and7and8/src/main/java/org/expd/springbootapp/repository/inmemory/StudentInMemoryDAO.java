package org.expd.springbootapp.repository.inmemory;

import org.expd.springbootapp.model.Student;
import org.expd.springbootapp.repository.BaseDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Profile("test")
public class StudentInMemoryDAO implements BaseDAO<Student> {

    private HashMap<Integer, Student> students = new HashMap<>();

    private static int nextId = 0;

    @Override
    public Student insert(Student student) {
        student.setId(nextId++);
        this.students.put(student.getId(), student);
        return student;
    }

    @Override
    public void update(Student student) {
        this.students.put(student.getId(), student);
    }

    @Override
    public void delete(int id) {
        this.students.remove(id);
    }

    @Override
    public Student get(int id) {
        return this.students.get(id);
    }

    @Override
    public List<Student> getAll() {
        return this.students.values().stream().toList();
    }

    @Override
    public void clearDatabase() {
        this.students = null;
    }

    @Override
    public void initDatabase() {
        nextId = 0;
        this.students = new HashMap<Integer, Student>();
    }
}
