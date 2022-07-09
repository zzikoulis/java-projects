package gr.aueb.cf.schoolapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.schoolapp.dao.IStudentDAO;
import gr.aueb.cf.schoolapp.dto.StudentDTO;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.service.exceptions.StudentNotFoundException;

public class StudentServiceImpl implements IStudentService{
	
	private final IStudentDAO studentDAO;
	
	public StudentServiceImpl(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void insertStudent(StudentDTO studentDTO) throws SQLException {
		//Extract DTO
		Student student = new Student();
		student.setSname(studentDTO.getSname());
		student.setFname(studentDTO.getFname());
		
		try {
			studentDAO.insert(student);
		} catch (SQLException e) {
			throw e;
		}
		
		
	}

	@Override
	public void deleteStudent(StudentDTO studentDTO) throws StudentNotFoundException, SQLException {
		Student studentToDelete = new Student();
		studentToDelete.setId(studentDTO.getId());
		
		try {
			if (studentDAO.getStudentById(studentToDelete.getId()) != null) {
				studentDAO.delete(studentToDelete);
			} else {
				throw new StudentNotFoundException(studentToDelete);
			}
		} catch (StudentNotFoundException | SQLException e) {
			throw e;
		}
	}

	@Override
	public void updateStudent(StudentDTO oldStudentDTO, StudentDTO newStudentDTO)
			throws StudentNotFoundException, SQLException {
		// extract DTO
		Student studentToUpdate = new Student();
		studentToUpdate.setId(oldStudentDTO.getId());
		
		Student newStudent = new Student();
		newStudent.setSname(newStudentDTO.getSname());
		newStudent.setFname(newStudentDTO.getFname());
		
		// forward to DAO
		try {
			if (studentDAO.getStudentById(studentToUpdate.getId()) != null) {
				studentDAO.update(studentToUpdate, newStudent);
			} else {
				throw new StudentNotFoundException(studentToUpdate);
			}
		} catch (StudentNotFoundException | SQLException e) {
			throw e;
		}
		
	}

	@Override
	public List<Student> getStudentsByLastname(String lastname) throws SQLException {
		try {
			return studentDAO.getStudentsByLastname(lastname);
		} catch (SQLException e) {
			throw e;
		}
	}

}
