package gr.aueb.cf.schoolapp.dao;

import java.sql.SQLException;
import java.util.List;
import gr.aueb.cf.schoolapp.model.Student;

public interface IStudentDAO {
	void insert(Student student) throws SQLException;
	void delete(Student student) throws SQLException;
	void update(Student oldStudent, Student newStudent) throws SQLException;
	List<Student> getStudentsByLastname(String lastname) throws SQLException;
	Student getStudentById(int id) throws SQLException;
}