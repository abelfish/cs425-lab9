package edu.miu.cs.cs425.studentmgmt.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseCode;
    private String courseName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "courses_students",
            joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "courseId"),
                    @JoinColumn(name = "course_name",
                            referencedColumnName = "courseName")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private List<Student> students = new ArrayList<>();


    public Course(Integer courseId, String courseCode, String courseName, List<Student> students) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        if (students != null) {

            this.students = students;
        }
    }

    public void addStudent(Student student) {
        if (this.students.contains(student)) {
            return;
        }
        this.students.add(student);
    }


}
