package org.expd.springbootapp.service;

import org.expd.springbootapp.model.Course;
import org.expd.springbootapp.repository.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private BaseDAO<Course> courseDAO;

    public Course createCourse(String courseCode, String courseName){
        Course course = new Course(courseCode, courseName);
        Course insertedCourse = courseDAO.insert(course);
        return insertedCourse;
    }

    public void updateCourse(Course course){
        this.courseDAO.update(course);
    }

    public void deleteCourse(int id){
        this.courseDAO.delete(id);
    }

    public Course getCourse(int courseId){

        return this.courseDAO.get(courseId);
    }

    //TODO implement query method in DAO.
    public Course getCourseByCode(String courseCode) {
        List<Course> courses = this.courseDAO.getAll();
        Course course = courses.stream().filter(c -> c.getCode().equals(courseCode)).findFirst()
                .orElseThrow();
        return course;
    }

    public void clearDatabase(){
        this.courseDAO.clearDatabase();
    }

    public void initDatabase(){
        this.courseDAO.initDatabase();
    }


}
