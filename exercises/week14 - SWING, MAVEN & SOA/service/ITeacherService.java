package gr.aueb.cf.schoolapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.schoolapp.dto.TeacherDTO;
import gr.aueb.cf.schoolapp.service.exceptions.TeacherIdAlreadyExistsException;
import gr.aueb.cf.schoolapp.service.exceptions.TeacherNotFoundException;
import gr.aueb.cf.schoolapp.model.Teacher;

public interface ITeacherService {
	/**
	 * Inserts a {@link Teacher} based on the data carried by the {@link TeacherDTO}.
	 * 
	 * @param teacherDTO
	 * 			DTO object that contains the data
	 * @throws TeacherIdAlreadyExistsException
	 * 			if any teacher, identified by their id, needed to be inserted has already been inserted
	 * @throws SQLException
	 * 			if any error happens during SQL insert statement
	 */
	void insertTeacher(TeacherDTO teacherDTO) 
			throws TeacherIdAlreadyExistsException, SQLException;
	
	/**
	 * Removes a {@link Teacher} based on the data carried by the {@link TeacherDTO}.
	 * 
	 * @param teacherDTO
	 * 			DTO object that contains the data (mainly the id) 
	 * @throws TeacherNotFoundException
	 * 			if any teacher, identified by their id, needed to be removed not found
	 * @throws SQLException
	 * 			if any error happens during SQL delete statement
	 */
	void deleteTeacher(TeacherDTO teacherDTO)
			throws TeacherNotFoundException, SQLException;
	
	/**
	 * Updates a {@link Teacher} based on the data carried by the {@link TeacherDTO}
	 * 
	 * @param oldTeacherDTO
	 * 			DTO object that contains the data (mainly the id) of the teacher instance that will be updated
	 * @param newTeacherDTO
	 * 			DTO object that contains the data of the new teacher
	 * @throws TeacherNotFoundException
	 * 			if any teacher, identified by their id, needed to be updated not found
	 * @throws SQLException
	 * 			if any error happens during SQL update statement
	 */
	void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO)
			throws TeacherNotFoundException, SQLException;
	
	/**
	 * Gets back to the caller a list of the {@link Teacher} objects identified by their lastname or lastname's initial characters
	 * 
	 * @param lastname
	 * 			a string object that contains the lastname or the initial characters that lastname starts with
	 * @return
	 * 			a list that contains the results of the search, or null if no results are found
	 * @throws SQLException
	 * 			if any error happens during SQL select statement
	 */
	List<Teacher> getTeachersByLastname(String lastname)
			throws SQLException;
	

}
