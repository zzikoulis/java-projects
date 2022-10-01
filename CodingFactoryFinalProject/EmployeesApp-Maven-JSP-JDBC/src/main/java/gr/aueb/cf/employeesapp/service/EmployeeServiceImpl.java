package gr.aueb.cf.employeesapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.employeesapp.dao.IEmployeeDAO;
import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.model.Employee;

public class EmployeeServiceImpl implements IEmployeeService {

	private final IEmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void insertEmployee(EmployeeDTO employeeDTO) throws SQLException {
		// Extract dto
		Employee employee = new Employee();
		employee.setFirstname(employeeDTO.getFirstname());
		employee.setLastname(employeeDTO.getLastname());
		
		try {
			employeeDAO.insert(employee);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void deleteEmployee(EmployeeDTO employeeDTO)
			throws SQLException {  // EmployeeNotFoundException
		Employee employeeToDelete = new Employee();
		employeeToDelete.setId(employeeDTO.getId());
		
		try {
			employeeDAO.delete(employeeToDelete);
		} catch (SQLException e) {  // EmployeeNotFoundException
			throw e;
		}
	}

	@Override
	public void updateEmployee(EmployeeDTO oldEmployeeDTO, EmployeeDTO newEmployeeDTO)
			throws SQLException {   // EmployeeNotFoundException
		
		// extract DTO
		Employee employeeToUpdate = new Employee();
		employeeToUpdate.setId(oldEmployeeDTO.getId());
		
		Employee newEmployee = new Employee();
		newEmployee.setFirstname(newEmployeeDTO.getFirstname());
		newEmployee.setLastname(newEmployeeDTO.getLastname());

		// Forward to DAO
		try {
				employeeDAO.update(employeeToUpdate, newEmployee);
		} catch (SQLException e) { //EmployeeNotFoundException
			throw e;
		}
	}

	@Override
	public List<Employee> getEmployeeByLastname(String lastname) throws SQLException {
		try {
			return employeeDAO.getEmployeesByLastname(lastname);
		} catch (SQLException e) {
			throw e;
		}
	}
}