package gr.aueb.cf.employeesapp.service.exceptions;

import gr.aueb.cf.employeesapp.model.Employee;

public class EmployeeIdAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EmployeeIdAlreadyExistsException(Employee employee) {
		super("Employee with id = " + employee.getId() + " already exists");
	}
}

