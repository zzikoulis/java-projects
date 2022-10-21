package gr.aueb.cf.employeesapp.service;

import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.model.Employee;
import gr.aueb.cf.employeesapp.service.exceptions.EmployeeNotFoundException;

import java.util.List;

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
     * @throws EmployeeNotFoundException
     * 			if no Employee was found to delete
     */
    void deleteEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException;

    /**
     *
     * Updates a {@link Employee} based on the data carried by the {@link EmployeeDTO}
     *
     * @param employeeDTO
     * 			DTO object that contains the data to update based on the id
     *
     * @throws EmployeeNotFoundException
     * 			if no Employee was found to update
     */
    void updateEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException;


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
     * @throws EmployeeNotFoundException
     * 		if no Employee was found
     */
    List<Employee> getEmployeesByLastname(String lastname) throws EmployeeNotFoundException;
}
