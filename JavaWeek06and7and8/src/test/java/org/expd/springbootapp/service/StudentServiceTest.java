package org.expd.springbootapp.service;

import org.expd.springbootapp.model.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class StudentServiceTest {


    @Autowired
    private StudentService studentService;

    @BeforeEach
    public void setup(){
        this.studentService.clearDatabase();
        this.studentService.initDatabase();
        this.studentService.create("Student Test");
    }

    @Test
    public void testGetAll(){
        List<Student> students = this.studentService.getStudents();
        Assertions.assertEquals(1, students.size());
    }

    @Test
    public void testCreateStudent(){
        Student s = this.studentService.create("Test Student");
        Assertions.assertEquals(1, s.getId());
    }

    @Test
    public void testGetById(){
        Student student = this.studentService.getStudent(0);
        Assertions.assertEquals(0, student.getId());
    }
    @Test
    public void testDelete(){
        studentService.deleteStudent(0);
        Student student = this.studentService.getStudent(0);
        Assertions.assertNull(student);
    }


    @Test
    public void testUpdateStudent(){
        String studentNewName = "Updated By Test Student";
        Student student = this.studentService.getStudent(0);
        student.setName(studentNewName);
        this.studentService.updateStudent(student);
        Student updatedStudent = this.studentService.getStudent(0);

        Assertions.assertEquals(studentNewName, updatedStudent.getName());

    }

}
