package gr.aueb.cf.employeesapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gr.aueb.cf.employeesapp.dao.IEmployeeDAO;
import gr.aueb.cf.employeesapp.dao.EmployeeDAOImpl;
import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.model.Employee;
import gr.aueb.cf.employeesapp.service.IEmployeeService;
import gr.aueb.cf.employeesapp.service.EmployeeServiceImpl;
import gr.aueb.cf.employeesapp.service.exceptions.EmployeeNotFoundException;

@WebServlet("/search")
public class SearchEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
	IEmployeeService employeeServ = new EmployeeServiceImpl(employeeDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String lastname = request.getParameter("lastname");
		List<Employee> employees;
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setLastname(lastname);
		
		try {
			employees = employeeServ.getEmployeesByLastname(lastname);
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("/jsps/employees.jsp").forward(request, response);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			request.setAttribute("employeesNotFound", true);
			request.getRequestDispatcher("/jsps/employeesmenu.jsp").forward(request, response);
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/employeesmenu.jsp").forward(request, response);
		}
	}
}
