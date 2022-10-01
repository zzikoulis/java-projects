package gr.aueb.cf.employeesapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.employeesapp.dao.IEmployeeDAO;
import gr.aueb.cf.employeesapp.dao.EmployeeDAOImpl;
import gr.aueb.cf.employeesapp.model.Employee;
import gr.aueb.cf.employeesapp.service.IEmployeeService;
import gr.aueb.cf.employeesapp.service.EmployeeServiceImpl;


@WebServlet("/search")
public class SearchEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
	IEmployeeService employeeServ = new EmployeeServiceImpl(employeeDAO);
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String lastname = request.getParameter("lastname");

		try {
			List<Employee> employees = employeeServ.getEmployeeByLastname(lastname);
			if (employees != null) {
				request.setAttribute("employees", employees);
				request.getRequestDispatcher("/jsps/employees.jsp").forward(request, response);
			} else {
				request.setAttribute("employeesNotFound", true);
				request.getRequestDispatcher("/jsps/employeesmenu.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/employeesmenu.jsp").forward(request, response);
		}
		
	}

}
