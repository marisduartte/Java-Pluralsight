package org.expd.springbootapp.service;

import org.expd.springbootapp.model.ScheduledClass;
import org.expd.springbootapp.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class RegistrationServiceTest {

    @Autowired
    RegistrationService registrationService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;
    @Autowired
    ClassService classService;
    private String correctCourseCode;
    private String wrongCourseCode;

    @BeforeEach
    public void setup(){
        this.correctCourseCode = "EI000";
        this.wrongCourseCode = "EI001";
        this.courseService.createCourse(this.correctCourseCode, "Java Training");
    }

    @Test
    public void testAddNewClassToCourse(){
        ScheduledClass sClass = this.registrationService.addNewClassToCourse(this.correctCourseCode, LocalDate.now(), LocalDate.now());
        Assertions.assertEquals(this.correctCourseCode, sClass.getCourse().getCode());
    }

    @Test
    public void testAddNewClassToCourseThrowNoSuchElementEx(){
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            this.registrationService.addNewClassToCourse(this.wrongCourseCode, LocalDate.now(), LocalDate.now());
        });
    }

    @Test
    public void testAddStudentToClass(){
        Student student = this.studentService.create("Test student");
        ScheduledClass sc = this.classService.createScheduledClass("EI000",LocalDate.now(), LocalDate.now());

        this.registrationService.registerStudentForClass(student.getId(), sc.getCourse().getCode(), sc.getStartDate());

        List<Student> students = this.registrationService.getStudentsForClass(sc.getCourse().getCode(), sc.getStartDate());

        Assertions.assertEquals(1, students.size());
        Assertions.assertEquals(sc.getCourse().getCode(), students.getFirst().getClasses().getFirst().getCourse().getCode());
    }

    @Test
    public void testDropStudentFromClass(){
        Student student = this.studentService.create("Test student");
        Student student2 = this.studentService.create("Test student2");

        ScheduledClass sc = this.classService.createScheduledClass("EI000",LocalDate.now(), LocalDate.now());

        this.registrationService.registerStudentForClass(student.getId(), sc.getCourse().getCode(), sc.getStartDate());
        this.registrationService.registerStudentForClass(student2.getId(), sc.getCourse().getCode(), sc.getStartDate());

        List<Student> students = this.registrationService.getStudentsForClass(sc.getCourse().getCode(), sc.getStartDate());

        Assertions.assertEquals(2, students.size());
        Assertions.assertEquals(sc.getCourse().getCode(), students.getFirst().getClasses().getFirst().getCourse().getCode());

        this.registrationService.dropStudentFromClass(student.getId(), sc.getCourse().getCode(), sc.getStartDate());

        students = this.registrationService.getStudentsForClass(sc.getCourse().getCode(), sc.getStartDate());

        Assertions.assertEquals(1, students.size());
        Assertions.assertEquals(sc.getCourse().getCode(), students.getFirst().getClasses().getFirst().getCourse().getCode());

    }
}
