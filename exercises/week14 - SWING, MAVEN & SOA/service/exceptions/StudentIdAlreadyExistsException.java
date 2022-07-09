package gr.aueb.cf.schoolapp.service.exceptions;

import gr.aueb.cf.schoolapp.model.Student;

public class StudentIdAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public StudentIdAlreadyExistsException(Student student) {
		super("Student with id = " + student.getId() + " already exists");
	}
}
