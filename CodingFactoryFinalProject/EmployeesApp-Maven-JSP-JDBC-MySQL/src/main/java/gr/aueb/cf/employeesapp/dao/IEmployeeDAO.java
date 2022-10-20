package gr.aueb.cf.employeesapp.dao;

import java.sql.SQLException;
import java.util.List;
import gr.aueb.cf.employeesapp.model.Employee;

public interface IEmployeeDAO {

	/**
	 * Inserts a {@link Employee} in datasource
	 *
	 * @param employee
	 * 			the {@link Employee} object to be inserted
	 * @throws SQLException
	 * 			if any error happens during SQL insert
	 */
	void insert(Employee employee) throws SQLException;

	/**
	 * Removes a {@link Employee} based on its data carried
	 *
	 * @param employee
	 * 			the {@link Employee} object to be removed
	 * @throws SQLException
	 * 			if any error happens during SQL insert delete
	 */
	void delete(Employee employee) throws SQLException;

	/**
	 * Updates a {@link Employee} with new data based on its old data carried
	 *
	 * @param oldEmployee
	 * 			Model object that contains the data -mainly the id- of the employee
	 * 			that will be updated
	 * @param newEmployee
	 * 			Model object that contains the data of the new employee
	 * @throws SQLException
	 * 			if any error happens during SQL update
	 */
	void update(Employee oldEmployee, Employee newEmployee) throws SQLException;

	/**
	 * Gets back to the caller a list of the {@link Employee} objects identified
	 * by their lastname or lastname's initial characters
	 * @param lastname
	 * 			a string object that contains the lastname or the initial letters
	 *  		that lastname starts with
	 * @return
	 *          a list that contains the results of the search, or null if no
	 * 	        results are found
	 * @throws SQLException
	 * 			if any error happens during SQL search
	 */
	List<Employee> getEmployeesByLastname(String lastname) throws SQLException;

	/**
	 * Gets back to the caller a {@link Employee} object identified by its id
	 * @param id
	 * 			the id of the employee to be found
	 * @return
	 * 			a {@link Employee} object, or null if no employees found
	 * @throws SQLException
	 * 			if any error happens during SQL search
	 */
	Employee getEmployeeById(int id) throws SQLException;
}
