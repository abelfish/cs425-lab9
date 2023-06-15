package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.repository.CourseRepository;
import edu.miu.cs.cs425.studentmgmt.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Integer courseId) {

       return courseRepository.findById(courseId).orElseThrow(()->new IllegalArgumentException(
               "Invalid course Id: "+courseId));

    }

    @Override
    public void deleteCourseById(Integer courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course updateCourse(Course course) {
        courseRepository.findById(course.getCourseId()).orElseThrow(()->new IllegalArgumentException(
                "Invalid course Id: "+ course.getCourseId()));

        return courseRepository.save(course);
    }
}
