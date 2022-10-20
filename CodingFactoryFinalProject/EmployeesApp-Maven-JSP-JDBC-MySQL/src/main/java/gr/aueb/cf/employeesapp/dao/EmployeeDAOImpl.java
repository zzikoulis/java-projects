package gr.aueb.cf.employeesapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gr.aueb.cf.employeesapp.model.Employee;

import static gr.aueb.cf.employeesapp.dao.dbutil.DBUtil.openConnection;
import static gr.aueb.cf.employeesapp.dao.dbutil.DBUtil.closeConnection;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public void insert(Employee employee) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			String sql = "INSERT INTO EMPLOYEES (FIRSTNAME, LASTNAME) VALUES (?, ?)";

			pst = openConnection().prepareStatement(sql);
			pst.setString(1,  employee.getFirstname());
			pst.setString(2,  employee.getLastname());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}	
	}

	@Override
	public void delete(Employee employee) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			String sql = "DELETE FROM EMPLOYEES WHERE ID =  ?";

			pst = openConnection().prepareStatement(sql);
			pst.setInt(1,  employee.getId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

	@Override
	public void update(Employee oldEmployee, Employee newEmployee) throws SQLException {
		PreparedStatement pst = null;
		
		try {
			String sql = "UPDATE EMPLOYEES SET FIRSTNAME = ?, LASTNAME = ? WHERE ID = ?" ;

			pst = openConnection().prepareStatement(sql);
			pst.setString(1, newEmployee.getFirstname());
			pst.setString(2, newEmployee.getLastname());
			pst.setInt(3, oldEmployee.getId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}

	@Override
	public List<Employee> getEmployeesByLastname(String lastname) throws SQLException {
		PreparedStatement pst = null;
		List<Employee> employees = new ArrayList<>();
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT ID, FIRSTNAME, LASTNAME FROM EMPLOYEES WHERE LASTNAME LIKE ?";

			pst = openConnection().prepareStatement(sql);
			pst.setString(1, lastname + '%');
			rs =  pst.executeQuery();
				
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setFirstname(rs.getString("FIRSTNAME"));
				employee.setLastname(rs.getString("LASTNAME"));

				employees.add(employee);
			}

			return (employees.size() > 0) ? employees : null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
		
	}

	@Override
	public Employee getEmployeeById(int id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Employee employee = null;
		
		try {
			
			String sql = "SELECT * FROM EMPLOYEES WHERE ID = ?";
			
			pst = openConnection().prepareStatement(sql);
			pst.setInt(1, id);
			rs =  pst.executeQuery();
				
			if (rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt("ID"));
				employee.setFirstname(rs.getString("FIRSTNAME"));
				employee.setLastname(rs.getString("LASTNAME"));
			}
		
			return employee;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (pst != null) pst.close();
			if (openConnection() != null) closeConnection();
		}		
	}
}
