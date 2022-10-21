package gr.aueb.cf.employeesapp.controller;

import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.service.IEmployeeService;
import gr.aueb.cf.employeesapp.service.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Long id, @RequestParam String firstname,
                                 @RequestParam String lastname, Model model) {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(id);
        employeeDTO.setFirstname(firstname);
        employeeDTO.setLastname(lastname);

        try {
            employeeService.deleteEmployee(employeeDTO);
            model.addAttribute("employee", employeeDTO);
            return ("employeedeleted");
        } catch (EmployeeNotFoundException e) {
            model.addAttribute("deleteAPIError", true);
            return ("employees");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("sqlError", "Error in database operation. Please try again!");
            return ("employeesmenu");
        }
    }
}
