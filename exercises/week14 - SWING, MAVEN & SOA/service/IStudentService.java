package gr.aueb.cf.schoolapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.schoolapp.dto.StudentDTO;
import gr.aueb.cf.schoolapp.service.exceptions.StudentIdAlreadyExistsException;
import gr.aueb.cf.schoolapp.service.exceptions.StudentNotFoundException;
import gr.aueb.cf.schoolapp.model.Student;

public interface IStudentService {
	/**
	 * Inserts a {@link Student} based on the data carried by the {@link StudentDTO}.
	 * 
	 * @param studentDTO
	 * 			DTO object that contains the data
	 * @throws StudentIdAlreadyExistsException
	 * 			if any student, identified by their id, needed to be inserted has already been inserted
	 * @throws SQLException
	 * 			if any error happens during SQL insert statement
	 */
	void insertStudent(StudentDTO studentDTO) 
			throws StudentIdAlreadyExistsException, SQLException;
	
	/**
	 * Removes a {@link Student} based on the data carried by the {@link StudentDTO}.
	 * 
	 * @param studentDTO
	 * 			DTO object that contains the data (mainly the id) 
	 * @throws StudentNotFoundException
	 * 			if any student, identified by their id, needed to be removed not found
	 * @throws SQLException
	 * 			if any error happens during SQL delete statement
	 */
	void deleteStudent(StudentDTO studentDTO)
			throws StudentNotFoundException, SQLException;
	
	/**
	 * Updates a {@link Student} based on the data carried by the {@link StudentDTO}
	 * 
	 * @param oldStudentDTO
	 * 			DTO object that contains the data (mainly the id) of the student instance that will be updated
	 * @param newStudentDTO
	 * 			DTO object that contains the data of the new student
	 * @throws StudentNotFoundException
	 * 			if any student, identified by their id, needed to be updated not found
	 * @throws SQLException
	 * 			if any error happens during SQL update statement
	 */
	void updateStudent(StudentDTO oldStudentDTO, StudentDTO newStudentDTO)
			throws StudentNotFoundException, SQLException;
	
	/**
	 * Gets back to the caller a list of the {@link Student} objects identified by their lastname or lastname's initial characters
	 * 
	 * @param lastname
	 * 			a string object that contains the lastname or the initial characters that lastname starts with
	 * @return
	 * 			a list that contains the results of the search, or null if no results are found
	 * @throws SQLException
	 * 			if any error happens during SQL select statement
	 */
	List<Student> getStudentsByLastname(String lastname)
			throws SQLException;
	

}
