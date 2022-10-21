package gr.aueb.cf.employeesapp.controller;

import gr.aueb.cf.employeesapp.dao.IEmployeeDAO;
import gr.aueb.cf.employeesapp.dao.EmployeeDAOImpl;
import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.service.IEmployeeService;
import gr.aueb.cf.employeesapp.service.EmployeeServiceImpl;
import gr.aueb.cf.employeesapp.service.exceptions.EmployeeNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
	IEmployeeService employeeServ = new EmployeeServiceImpl(employeeDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");

		Long id = Long.parseLong(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(id);
		employeeDTO.setFirstname(firstname);
		employeeDTO.setLastname(lastname);
	
		try {
			employeeServ.deleteEmployee(employeeDTO);
			request.setAttribute("employee", employeeDTO);
			request.getRequestDispatcher("/jsps/employeedeleted.jsp").forward(request, response);
		} catch (EmployeeNotFoundException e) {
			request.setAttribute("deleteAPIError", true);
			request.getRequestDispatcher("/jsps/employees.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/employeesmenu.jsp").forward(request, response);
		}
	}
}
