package gr.aueb.cf.employeesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuEmployeeController {

    @GetMapping("/main")
    public String getMainMenu() {
        return "employeesmenu.html";
    }
}
