package gr.aueb.cf.employeesapp.controller;

import gr.aueb.cf.employeesapp.model.Employee;
import gr.aueb.cf.employeesapp.service.IEmployeeService;
import gr.aueb.cf.employeesapp.service.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/search")
    public String searchEmployee(@RequestParam String lastname, Model model) {

        List<Employee> employees;

        try {
            employees = employeeService.getEmployeesByLastname(lastname+"%");
            model.addAttribute("employees", employees);
            return ("employees");
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            model.addAttribute("employeesNotFound", "No employees found");
            return ("employeesmenu");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("sqlError", "Error in database operation. Please try again!");
            return ("employeesmenu");
        }
    }
}
