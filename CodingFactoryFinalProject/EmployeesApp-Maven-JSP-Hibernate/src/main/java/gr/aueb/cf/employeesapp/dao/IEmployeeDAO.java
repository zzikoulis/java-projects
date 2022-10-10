package gr.aueb.cf.employeesapp.dao;

import java.util.List;

import gr.aueb.cf.employeesapp.model.Employee;

public interface IEmployeeDAO {
	void insert(Employee employee);
	void delete(Employee employee);
	void update(Employee employee);
	List<Employee> getEmployeesByLastname(String lastname);
	Employee getEmployeeById(Long id);
}
