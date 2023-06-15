package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Student;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student);
    Student getStudentById(Integer studentId);
    void deleteStudentById(Integer studentId);
    Student updateStudent(Student student);

    List<Student> getAllStudents();


}
