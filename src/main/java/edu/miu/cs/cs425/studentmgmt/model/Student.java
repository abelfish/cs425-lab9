package edu.miu.cs.cs425.studentmgmt.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotEmpty(message = "Please provide student number")
    @NotNull(message = "Please provide student number")
    private String studentNumber;
    @NotEmpty(message = "Please provide first name")
    @NotNull(message = "Please provide first name")
    private String firstName;
    private String middleName;
    @NotEmpty(message = "Please provide last name")
    @NotNull(message = "Please provide last name")
    private String lastName;
    private Double cgpa;
    private LocalDate dateOfEnrollment;

    @OneToOne
    @JoinColumn(name = "transcript_id")
    private Transcript transcript;

    @ManyToMany(mappedBy = "students",fetch = FetchType.EAGER)
    private List<Course> courses = new ArrayList<>();

    public Student(Long studentId,  String studentNumber,  String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment, Transcript transcript, List<Course> courses) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcript = transcript;
        if(courses != null) {
            this.courses = courses;
        }
    }

    public void addCourse(Course course) {
        if(this.courses.contains(course)) {
            return;
        }
        this.courses.add(course);
    }
}