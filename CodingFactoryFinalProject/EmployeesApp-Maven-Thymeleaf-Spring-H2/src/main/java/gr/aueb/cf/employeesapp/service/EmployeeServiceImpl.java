package gr.aueb.cf.employeesapp.service;

import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.model.Employee;
import gr.aueb.cf.employeesapp.repository.EmployeeRepository;
import gr.aueb.cf.employeesapp.service.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public void insertEmployee(EmployeeDTO employeeDTO) {
        Employee employee = convertToEmployee(employeeDTO);

        try {
            if (employeeDTO.getId() == null) {
                employeeRepository.save(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException {
        Employee employeeToDelete = convertToEmployee(employeeDTO);

        if (employeeRepository.findById(employeeToDelete.getId()).isEmpty()) {
            throw new EmployeeNotFoundException(Employee.class, employeeToDelete.getId());
        }

        try {
            employeeRepository.delete(employeeToDelete);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException {
        Employee employeeToUpdate = convertToEmployee(employeeDTO);

        if (employeeRepository.findById(employeeToUpdate.getId()).isEmpty()) {
            throw new EmployeeNotFoundException(Employee.class, employeeToUpdate.getId());
        }

        try {
            employeeRepository.save(employeeToUpdate);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Employee> getEmployeesByLastname(String lastname) throws EmployeeNotFoundException {
        try {
            List<Employee> employees = employeeRepository.getEmployeesByLastnameLike(lastname);

            if (employees.size() == 0) {
                throw new EmployeeNotFoundException(Employee.class, 0L);
            }

            return employees;

        }  catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private static Employee convertToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(), employeeDTO.getFirstname(), employeeDTO.getLastname());
    }
}
