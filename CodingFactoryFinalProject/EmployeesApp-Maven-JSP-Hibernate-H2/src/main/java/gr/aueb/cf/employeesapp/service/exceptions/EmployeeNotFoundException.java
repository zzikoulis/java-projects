package gr.aueb.cf.employeesapp.service.exceptions;

public class EmployeeNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EmployeeNotFoundException(Class<?> clazz, Long id) {
		super("Employee " + clazz.getSimpleName() + " with id " + id + " was not found");
	}
}
