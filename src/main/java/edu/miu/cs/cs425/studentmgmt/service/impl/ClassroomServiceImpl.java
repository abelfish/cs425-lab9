package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;

    @Override
    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    @Override
    public Classroom getClassroomById(Integer classroomId) {
        return classroomRepository.findById(classroomId).orElseThrow(()->new IllegalArgumentException(
                "Invalid classroom Id: "+classroomId));

    }

    @Override
    public void deleteClassroomById(Integer classroomId) {
        classroomRepository.deleteById(classroomId);
    }

    @Override
    public Classroom updateClassroom(Classroom classroom) {
        classroomRepository.findById(classroom.getClassroomId()).orElseThrow(()->new IllegalArgumentException(
                "Invalid classroom Id: "+ classroom.getClassroomId()));

        return classroomRepository.save(classroom);
    }
}
