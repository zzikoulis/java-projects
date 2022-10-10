package gr.aueb.cf.employeesapp.service;

import java.util.List;

import gr.aueb.cf.employeesapp.dao.IEmployeeDAO;
import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.model.Employee;
import gr.aueb.cf.employeesapp.service.exceptions.EntityNotFoundException;
import gr.aueb.cf.employeesapp.service.util.JPAHelper;

public class EmployeeServiceImpl implements IEmployeeService {
	
	private final IEmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public void insertEmployee(EmployeeDTO employeeDTO) {
		Employee employee;
		
		try {
			JPAHelper.beginTransaction();

			employee = new Employee();
			employee.setLastname(employeeDTO.getLastname());
			employee.setFirstname(employeeDTO.getFirstname());
			
			if (employeeDTO.getId() == null) {
				employeeDAO.insert(employee);
			} else {
				// option to update
			}
			JPAHelper.commitTransaction();
		} catch (Exception e) {
			JPAHelper.rollbackTransaction();
			throw e;
		} finally {
			JPAHelper.closeEntityManager();
		}
	}

	@Override
	public void deleteEmployee(EmployeeDTO employeeDTO) throws EntityNotFoundException {
		Employee employeeToDelete;
		
		try {
			JPAHelper.beginTransaction();

			employeeToDelete = new Employee();
			employeeToDelete.setId(employeeDTO.getId());
			
			if (employeeDAO.getEmployeeById(employeeToDelete.getId()) == null) {
				throw new EntityNotFoundException(Employee.class, employeeToDelete.getId());
			}

			employeeDAO.delete(employeeToDelete);
			
			JPAHelper.commitTransaction();
		} catch (Exception e) {
			JPAHelper.rollbackTransaction();
			throw e;
		} finally {
			JPAHelper.closeEntityManager();
		}
	}

	@Override
	public void updateEmployee(EmployeeDTO employeeDTO) throws EntityNotFoundException {
		Employee employeeToUpdate;
		
		try {
			JPAHelper.beginTransaction();

			employeeToUpdate = new Employee();
			employeeToUpdate.setId(employeeDTO.getId());
			employeeToUpdate.setLastname(employeeDTO.getLastname());
			employeeToUpdate.setFirstname(employeeDTO.getFirstname());
			
			if (employeeDAO.getEmployeeById(employeeToUpdate.getId()) == null) {
				throw new EntityNotFoundException(Employee.class, employeeToUpdate.getId());
			}

			employeeDAO.update(employeeToUpdate);
			
			JPAHelper.commitTransaction();
		} catch (Exception e) {
			JPAHelper.rollbackTransaction();
			throw e;
		} finally {
			JPAHelper.closeEntityManager();
		}
	}

	@Override
	public List<Employee> getEmployeesByLastname(String lastname) throws EntityNotFoundException {
		List<Employee> employees = null;
		
		try {
			JPAHelper.beginTransaction();

			employees = employeeDAO.getEmployeesByLastname(lastname);
			if (employees.size() == 0) throw new EntityNotFoundException(Employee.class, 0L);
//			if (employees.isEmpty()) throw new EntityNotFoundException(Employee.class, 0L);
			JPAHelper.commitTransaction();
		} catch (Exception e) {
			JPAHelper.rollbackTransaction();
			throw e;
		} finally {
			JPAHelper.closeEntityManager();
		}
		
		return employees;
	}
}
