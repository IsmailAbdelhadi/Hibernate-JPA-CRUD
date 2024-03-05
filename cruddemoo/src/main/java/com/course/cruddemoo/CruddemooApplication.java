package com.course.cruddemoo;

import com.course.cruddemoo.dao.StudentDao;
import com.course.cruddemoo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemooApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemooApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {

//			createStudent(studentDao);

			createMultipleStudent(studentDao);

//			readStudent(studentDao);

//			queryForStudents(studentDao);

//			updateStudent(studentDao);

//			deleteStudent(studentDao);
		};
	}

	private void deleteStudent(StudentDao studentDao) {
		int id = 2;

		studentDao.delete(id);
	}

	private void updateStudent(StudentDao studentDao) {

		int id = 2;
		Student myStudent = studentDao.findById(id);
		myStudent.setLastName("RASHAIDA");
		studentDao.update(myStudent);

	}

	private void queryForStudents(StudentDao studentDao) {
		List<Student> theStudents = studentDao.findAll();
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDao) {
		int id = 1;
		Student myStudent = studentDao.findById(id);
		System.out.println(myStudent);
	}

	private void createMultipleStudent(StudentDao studentDao) {
		// create the new students object
		System.out.println("creating the new students object ...");
		Student student = new Student("Hammam", "Mahmmoud", "Hemmo@gmail.com");
		Student student1 = new Student("Obada", "Abdelsalam", "Obada@gmail.com");
		Student student2 = new Student("Osama", "Alrashaydeh", "Osama@gmail.com");

		// save the students object
		System.out.println("saving the students ...");
		studentDao.save(student);
		studentDao.save(student1);
		studentDao.save(student2);

		// display id of the saved student
		System.out.println("Saves student. Generated id: " + student.getId());
		System.out.println("Saves student. Generated id: " + student1.getId());
		System.out.println("Saves student. Generated id: " + student2.getId());
	}

	private void createStudent(StudentDao studentDao) {

		// create the new student object
		System.out.println("creating new student object ...");
		Student tempstudent = new Student("Ismail", "Ahmad", "soom3a.99@gmail.com");

		// save the student object
		System.out.println("saving the student ...");
		studentDao.save(tempstudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempstudent.getId());
	}
}


