package gr.aueb.cf.employeesapp.controller;

import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.service.IEmployeeService;
import gr.aueb.cf.employeesapp.service.exceptions.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateEmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/update")
    public String getUpdateEmployeeForm(@RequestParam Long id, @RequestParam String firstname,
                                        @RequestParam String lastname, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("firstname", firstname);
        model.addAttribute("lastname", lastname);

        return ("employeeupdate");

    }

    @PostMapping("/update")
    public String updateEmployee(@RequestParam Long id, @RequestParam String firstname,
                                 @RequestParam String lastname, Model model) {

        if (firstname.equals("") || lastname.equals("")) {
            model.addAttribute("id", id);
            model.addAttribute("firstname", firstname);
            model.addAttribute("lastname", lastname);
            model.addAttribute("emptyError", "Firstname / Lastname can not be empty");

            return ("employeeupdate");
        }

        EmployeeDTO newEmployeeDTO = new EmployeeDTO();
        newEmployeeDTO.setId(id);
        newEmployeeDTO.setFirstname(firstname);
        newEmployeeDTO.setLastname(lastname);

        try {
            employeeService.updateEmployee(newEmployeeDTO);
            model.addAttribute("employee", newEmployeeDTO);
            return ("employeeupdated");
        } catch (EmployeeNotFoundException e) {
            model.addAttribute("updateAPIError", true);
            return ("employees");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("sqlError", "Error in database operation. Please try again!");
            return ("employeesmenu");
        }
    }
}
