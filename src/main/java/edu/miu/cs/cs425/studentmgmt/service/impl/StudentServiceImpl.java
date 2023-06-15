package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return null;
    }

    @Override
    public void deleteStudentById(Integer studentId) {

    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }
}
