package org.expd.springbootapp.service;

import org.expd.springbootapp.model.Course;
import org.expd.springbootapp.model.ScheduledClass;
import org.expd.springbootapp.repository.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ClassService {

    @Autowired
    private CourseService courseService;
    @Autowired
    private BaseDAO<ScheduledClass> classDAO;

    public ScheduledClass createScheduledClass(String courseCode, LocalDate startDate, LocalDate endDate)
    {
        Course course = courseService.getCourseByCode(courseCode);
        if(course != null){
            ScheduledClass sClass = new ScheduledClass(course, startDate, endDate);
            sClass = classDAO.insert(sClass);
            return sClass;
        }
        return null;
    }

    public void deleteScheduledClass(int id){
        ScheduledClass sClass = this.classDAO.get(id);
        if(sClass != null){
            this.classDAO.delete(id);
        }
    }

    public void updateScheduledClass(ScheduledClass sClass) {
        classDAO.update(sClass);
    }

    public ScheduledClass getScheduledClass(int id){
        return this.classDAO.get(id);
    }

    public List<ScheduledClass> getAllScheduledClasses(){
        return this.classDAO.getAll();
    }

    public List<ScheduledClass> getScheduledClassesByCourseCode(String code) {
        List<ScheduledClass> result = new ArrayList<ScheduledClass>();
        for (ScheduledClass sc : classDAO.getAll()) {
            if (sc.getCourse().getCode().equals(code)) {
                result.add(sc);
            }
        }

        return result;
    }
    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public BaseDAO<ScheduledClass> getClassDAO() {
        return classDAO;
    }

    public void setClassDAO(BaseDAO<ScheduledClass> classDAO) {
        this.classDAO = classDAO;
    }

    public void clearDatabase(){
        this.classDAO.clearDatabase();
    }

    public void initDatabase(){
        this.classDAO.initDatabase();
    }
}
