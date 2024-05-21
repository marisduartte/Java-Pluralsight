package org.expd.springbootapp.service;

import org.expd.springbootapp.model.Student;
import org.expd.springbootapp.repository.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private BaseDAO<Student> studentDAO;

    public Student create(String studentName){
        Student st = new Student(studentName);
        st = studentDAO.insert(st);
        return st;
    }

    public void updateStudent(Student student){
        this.studentDAO.update(student);
    }

    public void deleteStudent(int studentId){
        Student st = studentDAO.get(studentId);
        if(st != null)
            studentDAO.delete(studentId);
    }

    public List<Student> getStudents() {
        return  this.studentDAO.getAll();
    }

    public Student getStudent(int studentId) {
        return this.studentDAO.get(studentId);
    }

    public void clearDatabase() {
        this.studentDAO.clearDatabase();;
    }

    public void initDatabase() {
        this.studentDAO.initDatabase();
    }
}
