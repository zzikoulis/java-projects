package gr.aueb.cf.schoolapp.service.exceptions;

import gr.aueb.cf.schoolapp.model.Teacher;

public class TeacherIdAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TeacherIdAlreadyExistsException(Teacher teacher) {
		super("Teacher with id = " + teacher.getId() + " already exists");
	}
}
