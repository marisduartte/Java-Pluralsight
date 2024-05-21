package org.expd.springbootapp.service;

import org.expd.springbootapp.model.Course;
import org.expd.springbootapp.model.ScheduledClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class ClassServiceTest {

    @Autowired
    ClassService classService;

    @Autowired
    private CourseService courseService;

    private Course testCourse;
    @BeforeEach
    public void setup(){
        this.classService.clearDatabase();
        this.classService.initDatabase();

        this.courseService.initDatabase();

        this.testCourse = this.courseService.createCourse("DV001", "Software Development Essentials");
        this.classService.createScheduledClass(this.testCourse.getCode(), LocalDate.now(), LocalDate.now());

    }
    @Test
    public void testCreateScheduledClass(){
        ScheduledClass dv001 = this.classService.createScheduledClass(this.testCourse.getCode(), LocalDate.now(), LocalDate.now());
        Assertions.assertEquals(1, dv001.getId());
    }

    @Test
    public void testDeleteScheduledClass(){
        this.classService.deleteScheduledClass(0);
        List<ScheduledClass> classes = this.classService.getAllScheduledClasses();
        Assertions.assertEquals(0, classes.size());
    }
}
