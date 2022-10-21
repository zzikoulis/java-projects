package gr.aueb.cf.employeesapp.controller;

import gr.aueb.cf.employeesapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String eMail, @RequestParam String password, Model model) {

        if ( (eMail.equals("test@test.gr")) && (password.equals("test")) ) {
            return ("redirect:/main");
        } else {

            model.addAttribute("error", "Invalid name / password. Please try again!");
            return ("login");
        }
    }
}
