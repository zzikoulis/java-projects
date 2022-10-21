package gr.aueb.cf.employeesapp.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EmployeeDTO {

    private Long id;
    private String lastname;
    private String firstname;

    public EmployeeDTO() {}
}
