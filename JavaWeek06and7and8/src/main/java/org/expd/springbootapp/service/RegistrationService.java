package org.expd.springbootapp.service;

import org.expd.springbootapp.model.ScheduledClass;
import org.expd.springbootapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private CourseService courseService;
    @Autowired
    private ClassService classService;
    @Autowired
    private StudentService studentService;

    public RegistrationService(CourseService courseService, ClassService classService, StudentService studentService){
        this.courseService = courseService;
        this.classService = classService;
        this.studentService = studentService;
    }

    public ScheduledClass addNewClassToCourse(String courseCode, LocalDate startDate, LocalDate endDate){
        ScheduledClass sc = this.classService.createScheduledClass(courseCode, startDate, endDate);
        return sc;
    }


    public void registerStudentForClass(int studentId, String courseCode, LocalDate startDate){

        Student student = studentService.getStudent(studentId);
        List<ScheduledClass> allScheduledClasses = this.classService.getScheduledClassesByCourseCode(courseCode);
        ScheduledClass scheduledClass = allScheduledClasses
                .stream()
                .filter(sClass -> sClass.getStartDate().equals(startDate))
                .findFirst()
                .orElseThrow();
        student.addClass(scheduledClass);

    }

    public void dropStudentFromClass(int studentId, String courseCode, LocalDate startDate){
        Student student = studentService.getStudent(studentId);
        List<ScheduledClass> allScheduledClasses = this.classService.getScheduledClassesByCourseCode(courseCode);
        ScheduledClass scheduledClass = allScheduledClasses.stream().filter(sClass -> sClass.getStartDate().equals(startDate)).findFirst().orElseThrow();
        student.dropFromClass(scheduledClass);
    }

    public List<Student> getStudentsForClass(String courseCode, LocalDate startDate) {
        List<Student> students = this.studentService.getStudents();
        return students.stream()
                .filter(
                        st -> !st.getClasses()
                                .stream()
                                .filter(sc -> sc.getCourse().getCode().equals(courseCode)
                                        && sc.getStartDate().equals(startDate))
                                .toList()
                                .isEmpty()
                ).toList();

    }

    public CourseService getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public ClassService getClassService() {
        return classService;
    }

    public void setClassService(ClassService classService) {
        this.classService = classService;
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


}
