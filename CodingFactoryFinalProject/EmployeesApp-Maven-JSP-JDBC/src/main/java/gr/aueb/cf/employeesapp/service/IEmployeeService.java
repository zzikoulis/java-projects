package gr.aueb.cf.employeesapp.service;

import java.sql.SQLException;
import java.util.List;

import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.model.Employee;
import gr.aueb.cf.employeesapp.service.exceptions.EmployeeIdAlreadyExistsException;
import gr.aueb.cf.employeesapp.service.exceptions.EmployeeNotFoundException;

public interface IEmployeeService {
	
	/**
	 * Inserts a {@link Employee} based on the data carried by the {@link EmployeeDTO}.
	 * 
	 * @param employeeDTO
	 * 			DTO object that contains the data
	 * 
	 * @throws EmployeeIdAlreadyExistsException
	 * 			if any employee, identified by their id, needed to be inserted
	 * 			has already been inserted 
	 * @throws SQLException
	 * 			if any error happens during SQL insert 
	 */
	void insertEmployee(EmployeeDTO employeeDTO)
			throws SQLException;
	
	
	
	/**
	 * Removes a {@link Employee} based on the data carried by the {@link EmployeeDTO}.
	 *  
	 * @param employeeDTO
	 * 			DTO object that contains the data (mainly the id)
	 * @throws EmployeeNotFoundException
	 * 			if any employee, identified by their id, needed to be removed
	 * 			not found 
	 * @throws SQLException
	 * 			if any error happens during SQL delete 
	 */
	void deleteEmployee(EmployeeDTO employeeDTO)
			throws SQLException; // EmployeeNotFoundException,

	
	
	/**
	 * Updates a {@link Employee} based on the data carried by the {@link EmployeeDTO}.
	 * 
	 * @param oldEmployeeDTO
	 * 			DTO object hat contains the data -mainly the id- of the employee
	 * 			that will be updated.
	 * @param newEmployeeDTO
	 * 			DTO object that contains the data of the new employee.
	 * @throws EmployeeNotFoundException
	 * 			if any employee, identified by their id, needed to be updated
	 * 			not found 
	 * @throws SQLException
	 * 			if any error happens during SQL update 
	 */			
	void updateEmployee(EmployeeDTO oldEmployeeDTO, EmployeeDTO newEmployeeDTO)
			throws SQLException;  // EmployeeNotFoundException
	
	
	/**
	 * Gets back to the caller a list of the {@link Employee} objects identified
	 * by their lastname or lastname's initial characters
	 * 
	 * @param lastname
	 * 			a string object that contains the lastname or the initial letters
	 * 			that lastname starts with. 
	 * @return
	 * 			a list that contains the results of the search, or null if no
	 * 			results are found
	 * @throws SQLException
	 * 			if any error happens during SQL search 
	 */
	List<Employee> getEmployeeByLastname(String lastname) throws SQLException;
	
}
