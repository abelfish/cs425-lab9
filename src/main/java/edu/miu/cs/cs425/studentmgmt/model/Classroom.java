package edu.miu.cs.cs425.studentmgmt.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor

@Setter
@Getter
@Entity
@ToString
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classroomId;
    private String buildingName;
    private String roomNumber;


    @NonNull
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "classroom_id")
    private List<Student> students = new ArrayList<>();


    public Classroom(Integer classroomId, String buildingName, String roomNumber, List<Student> students) {
        this.classroomId = classroomId;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
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
