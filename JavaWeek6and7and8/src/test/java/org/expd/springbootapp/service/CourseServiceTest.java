package org.expd.springbootapp.service;

import org.expd.springbootapp.model.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @BeforeEach
    public void setup(){

        this.courseService.clearDatabase();
        this.courseService.initDatabase();
        this.courseService.createCourse("IS001", "Linux Introduction");
        this.courseService.createCourse("DV001", "Java 1290389048239084 Basic tips");

    }

    @Test
    public void testCreateCourse(){
        String courseCode = "DS001";
        String courseTitle = "Design Thinking";
        Course newCourse = this.courseService.createCourse(courseCode, courseTitle);

        Assertions.assertEquals(courseCode, newCourse.getCode());
        Assertions.assertEquals(courseTitle, newCourse.getTitle());
    }

    @Test
    public void testUpdateCourse(){
        String courseNewTile = "Java - Not THAT Complicated";
        Course course = this.courseService.getCourse(1);
        course.setTitle(courseNewTile);
        this.courseService.updateCourse(course);
        Course updatedCourse = this.courseService.getCourse(1);

        Assertions.assertEquals(courseNewTile, updatedCourse.getTitle());
    }

    @Test
    public void testDeleteCourse(){
        this.courseService.deleteCourse(0);
        Course shouldBeDeleted = this.courseService.getCourse(0);
        Assertions.assertNull(shouldBeDeleted, "This course should exists in database!");
    }
}
