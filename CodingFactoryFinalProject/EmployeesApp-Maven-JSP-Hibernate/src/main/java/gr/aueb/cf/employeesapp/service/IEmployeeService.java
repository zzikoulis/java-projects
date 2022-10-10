package gr.aueb.cf.employeesapp.service;

import java.util.List;

import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.model.Employee;
import gr.aueb.cf.employeesapp.service.exceptions.EntityNotFoundException;

public interface IEmployeeService {
	
	/**
	 * Inserts a {@link Employee} based on the data carried by the {@link EmployeeDTO}
	 * 
	 * @param employeeDTO
	 * 			DTO object that contains the data
	 */
	void insertEmployee(EmployeeDTO employeeDTO);
	
	/**
	 * 
	 * Removes a {@link Employee} based on the data carried by the {@link EmployeeDTO}
	 * 
	 * @param employeeDTO
	 * 			DTO object that contains the data (mainly the id)
	 * 
	 * @throws EntityNotFoundException
	 * 			if no Employee was found to delete
	 */
	void deleteEmployee(EmployeeDTO employeeDTO) throws EntityNotFoundException;
	
	/**
	 * 
	 * Updates a {@link Employee} based on the data carried by the {@link EmployeeDTO}
	 * 
	 * @param employeerDTO
	 * 			DTO object that contains the data to update based on the id
	 * 
	 * @throws EntityNotFoundException
	 * 			if no Employee was found to update
	 */
	void updateEmployee(EmployeeDTO employeeDTO) throws EntityNotFoundException;
	
	
	/**
	 * Gets back to the caller a list of {@link Employee} objects identified
	 * by the lastname's initial characters
	 * 
	 * @param lastname
	 * 		a string object that contains the lastname's initial characters
	 *  
	 * @return
	 * 		a list of {@link Employee} objects
	 * 
	 * @throws EntityNotFoundException
	 * 		if no Employee was found
	 */
	List<Employee> getEmployeesByLastname(String lastname) throws EntityNotFoundException;
}
