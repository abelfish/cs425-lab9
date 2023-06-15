package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course saveCourse(Course course);
    Course getCourseById(Integer courseId);
    void deleteCourseById(Integer courseId);
    Course updateCourse(Course course);

}
