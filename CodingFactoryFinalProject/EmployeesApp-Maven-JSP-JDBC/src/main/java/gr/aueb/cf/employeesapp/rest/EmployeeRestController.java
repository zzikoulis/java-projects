package gr.aueb.cf.employeesapp.rest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import gr.aueb.cf.employeesapp.dao.IEmployeeDAO;
import gr.aueb.cf.employeesapp.dao.EmployeeDAOImpl;
import gr.aueb.cf.employeesapp.model.Employee;
import gr.aueb.cf.employeesapp.service.IEmployeeService;
import gr.aueb.cf.employeesapp.service.EmployeeServiceImpl;

@WebServlet("/employees")
public class EmployeeRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
	IEmployeeService employeeServ = new EmployeeServiceImpl(employeeDAO);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		
		response.setHeader("Content-Type", "application/json; charset=UTF-8");
		
		String lastname = request.getParameter("lastname").trim();
		
		List<Employee> employees;
		String jsonString;
		Gson gson = new Gson();
		
		try {
			employees = employeeServ.getEmployeeByLastname(lastname);
			if (employees != null) {
				jsonString = gson.toJson(employees);
				
				// ObjectMapper mapper = new ObjectMapper();
				// jsonString = mapper.writeValueAsString(teachers);
				response.getWriter().write(jsonString);
				// JAX-RS -> Jersey / RESTEasy
				
			} else {
				response.getWriter().write("{}");
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().write("Error in database operation. Please try again!");
		}
	}
}
