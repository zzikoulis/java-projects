package gr.aueb.cf.employeesapp.service.exceptions;

import gr.aueb.cf.employeesapp.model.Employee;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(Employee employee) {
		super("Employee with id = " + employee.getId() + " was not found");
	}
}
