package org.expd.springbootapp.repository.inmemory;

import org.expd.springbootapp.model.Course;
import org.expd.springbootapp.model.ScheduledClass;
import org.expd.springbootapp.repository.BaseDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@Profile("test")
public class CourseInMemoryDAO implements BaseDAO<Course> {
    
    private static int nextId = 0;
    private HashMap<Integer, Course> courses = new HashMap<>();
    @Override
    public Course insert(Course course) {
        course.setId(nextId++);
        this.courses.put(course.getId(), course);
        return course;
    }

    @Override
    public void update(Course course) {
        this.courses.put(course.getId(), course);
    }

    @Override
    public void delete(int id) {
        this.courses.remove(id);
    }

    @Override
    public Course get(int id) {
        return this.courses.get(id);
    }

    @Override
    public List<Course> getAll() {
        return this.courses.values().stream().toList();
    }

    @Override
    public void clearDatabase() {
        this.courses = null;
    }

    @Override
    public void initDatabase() {
        nextId = 0;
        this.courses = new HashMap<Integer, Course>();
    }
}
