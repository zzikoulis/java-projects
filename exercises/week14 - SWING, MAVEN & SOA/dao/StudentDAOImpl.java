package gr.aueb.cf.schoolapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gr.aueb.cf.schoolapp.dao.dbutil.DBUtil;
import gr.aueb.cf.schoolapp.model.Student;

public class StudentDAOImpl implements IStudentDAO {

	@Override
	public void insert(Student student) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			String sql = "INSERT INTO STUDENTS (FIRSTNAME, LASTNAME) VALUES ('" 
					+ student.getFname() + "', '" + student.getSname() + "')";
			pst = DBUtil.openConnection().prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (DBUtil.openConnection() != null) DBUtil.closeConnection(); 
		}
	}

	@Override
	public void delete(Student student) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			
			String sql = "DELETE FROM STUDENTS WHERE ID = ?";
			pst = DBUtil.openConnection().prepareStatement(sql);
			pst.setInt(1, student.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (DBUtil.openConnection() != null) DBUtil.closeConnection(); 
		}
	}

	@Override
	public void update(Student oldStudent, Student newStudent) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			String sql = "UPDATE STUDENTS SET FIRSTNAME = '" + newStudent.getFname() + "', " + "LASTNAME = '" + newStudent.getSname() + "'"
					+ " WHERE ID = " + oldStudent.getId();
			pst = DBUtil.openConnection().prepareStatement(sql);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (DBUtil.openConnection() != null) DBUtil.closeConnection(); 
		}
	}

	@Override
	public List<Student> getStudentsByLastname(String lastname) throws SQLException {
		PreparedStatement pst = null;
		List<Student> students = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM STUDENTS WHERE LASTNAME LIKE '" + lastname + "%'";
			pst = DBUtil.openConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("ID"));
				student.setFname(rs.getString("FIRSTNAME"));
				student.setSname(rs.getString("LASTNAME"));
				
				students.add(student);
			}
			
			return (students.size() > 0) ? students : null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (DBUtil.openConnection() != null) DBUtil.closeConnection(); 
		}
	}

	@Override
	public Student getStudentById(int id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Student student = null;
		
		try {
			String sql = "SELECT * FROM STUDENTS WHERE ID = " + id;
			pst = DBUtil.openConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("ID"));
				student.setFname(rs.getString("FIRSTNAME"));
				student.setSname(rs.getString("LASTNAME"));
			}
			
			return (student != null) ? student : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (DBUtil.openConnection() != null) DBUtil.closeConnection(); 
		}
	}

}
