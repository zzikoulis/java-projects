package gr.aueb.cf.employeesapp.controller;

import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InsertEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    EmployeeDTO employeeDTO;

    @GetMapping("/insert")
    public String insertEmployee(@RequestParam String firstname,
                                 @RequestParam String lastname, Model model) {

        if (firstname.equals("") || lastname.equals("")) {
            model.addAttribute("emptyError", "Firstname / Lastname can not be empty");
            return ("employeesmenu");
        }

        employeeDTO.setFirstname(firstname);
        employeeDTO.setLastname(lastname);

        try {
            employeeService.insertEmployee(employeeDTO);
            model.addAttribute("insertedemployee", employeeDTO);
            return ("employeeinserted");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("sqlError", "Error in database operation. Please try again!");
            return ("employeesmenu");
        }
    }
}
