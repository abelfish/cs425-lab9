package edu.miu;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;
import edu.miu.cs.cs425.studentmgmt.service.CourseService;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {

	private final StudentService studentService;

	private final ClassroomService classroomService;
	private final TranscriptService transcriptService;
	private final CourseService courseService;


	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtApp.class, args);
	}

	@Override
	public void run(String... args)  {

		//create new Student
		var student1 = new Student(null,null,"Anna","Lynn","Smith",3.45,
				LocalDate.of(2019,5,24),null,null);
		//create a transcript for student1
		var transcript1 = transcriptService.saveTranscript(new Transcript(null,"BS Computer " +
				"Science"));

		//set transcript for student1
		student1.setTranscript(transcript1);


		//save student
		var savedStudent1 = studentService.saveStudent(student1);
		System.out.println("savedStudent1 = " + savedStudent1);


		//create new Student
		var student2 = new Student(null,"000-61-0002","John","Doe","Smith",3.45,
				LocalDate.of(2019,5,24),null,null);
		//create a transcript for student2
		var transcript2 = transcriptService.saveTranscript(new Transcript(null,"BS Computer " +
				"Science"));
		//set transcript for student2
		student2.setTranscript(transcript2);


		//save student
		var savedStudent2 = studentService.saveStudent(student2);
		System.out.println("savedStudent2 = " + savedStudent2);

		//create new classroom
		var students = List.of(savedStudent1,savedStudent2);
		var classroom1 = new Classroom (null,"McLaughlin building",
				"M105",students);

		//save classroom1
		var savedClassroom1 = classroomService.saveClassroom(classroom1);
		System.out.println("savedClassroom1 = " + savedClassroom1);

		//create new Course
		var course1 = new Course (null,"CS390","Advanced Software Engineering",null);
		//save course1
		var savedCourse1 = courseService.saveCourse(course1);
		//add course1 to student1
		savedStudent1.addCourse(savedCourse1);
		//save student1
		var updatedStudent1 = studentService.saveStudent(savedStudent1);
		System.out.println("updatedStudent1 = " + updatedStudent1);
		//add student1 to course1
		savedCourse1.addStudent(updatedStudent1);
		//save course1
		var updatedCourse1 = courseService.saveCourse(savedCourse1);
		System.out.println("updatedCourse1 = " + updatedCourse1);

	}



}
