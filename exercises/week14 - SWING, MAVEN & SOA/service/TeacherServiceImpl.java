package gr.aueb.cf.schoolapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
import gr.aueb.cf.schoolapp.dto.TeacherDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.exceptions.TeacherNotFoundException;

public class TeacherServiceImpl implements ITeacherService{
	
	private final ITeacherDAO teacherDAO;
	
	public TeacherServiceImpl(ITeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public void insertTeacher(TeacherDTO teacherDTO) throws SQLException {
		//Extract DTO
		Teacher teacher = new Teacher();
		teacher.setSname(teacherDTO.getSname());
		teacher.setFname(teacherDTO.getFname());
		
		try {
			teacherDAO.insert(teacher);
		} catch (SQLException e) {
			throw e;
		}
		
		
	}

	@Override
	public void deleteTeacher(TeacherDTO teacherDTO) throws TeacherNotFoundException, SQLException {
		Teacher teacherToDelete = new Teacher();
		teacherToDelete.setId(teacherDTO.getId());
		
		try {
			if (teacherDAO.getTeacherById(teacherToDelete.getId()) != null) {
				teacherDAO.delete(teacherToDelete);
			} else {
				throw new TeacherNotFoundException(teacherToDelete);
			}
		} catch (TeacherNotFoundException | SQLException e) {
			throw e;
		}
	}

	@Override
	public void updateTeacher(TeacherDTO oldTeacherDTO, TeacherDTO newTeacherDTO)
			throws TeacherNotFoundException, SQLException {
		// extract DTO
		Teacher teacherToUpdate = new Teacher();
		teacherToUpdate.setId(oldTeacherDTO.getId());
		
		Teacher newTeacher = new Teacher();
		newTeacher.setSname(newTeacherDTO.getSname());
		newTeacher.setFname(newTeacherDTO.getFname());
		
		// forward to DAO
		try {
			if (teacherDAO.getTeacherById(teacherToUpdate.getId()) != null) {
				teacherDAO.update(teacherToUpdate, newTeacher);
			} else {
				throw new TeacherNotFoundException(teacherToUpdate);
			}
		} catch (TeacherNotFoundException | SQLException e) {
			throw e;
		}
		
	}

	@Override
	public List<Teacher> getTeachersByLastname(String lastname) throws SQLException {
		try {
			return teacherDAO.getTeachersByLastname(lastname);
		} catch (SQLException e) {
			throw e;
		}
	}

}
