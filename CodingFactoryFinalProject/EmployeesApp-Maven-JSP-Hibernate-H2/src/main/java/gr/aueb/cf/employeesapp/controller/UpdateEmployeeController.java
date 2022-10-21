package gr.aueb.cf.employeesapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.aueb.cf.employeesapp.dao.IEmployeeDAO;
import gr.aueb.cf.employeesapp.dao.EmployeeDAOImpl;
import gr.aueb.cf.employeesapp.dto.EmployeeDTO;
import gr.aueb.cf.employeesapp.service.IEmployeeService;
import gr.aueb.cf.employeesapp.service.EmployeeServiceImpl;
import gr.aueb.cf.employeesapp.service.exceptions.EmployeeNotFoundException;

@WebServlet("/update")
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IEmployeeDAO employeeDAO = new EmployeeDAOImpl();
	IEmployeeService employeeServ = new EmployeeServiceImpl(employeeDAO);
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		EmployeeDTO newEmployeeDTO = new EmployeeDTO();
		newEmployeeDTO.setId(id);
		newEmployeeDTO.setFirstname(firstname);
		newEmployeeDTO.setLastname(lastname);
		
		
		try {
			employeeServ.updateEmployee(newEmployeeDTO);
			request.setAttribute("employee", newEmployeeDTO);
			request.getRequestDispatcher("/jsps/employeeupdated.jsp").forward(request, response);
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("sqlError", true);
			request.getRequestDispatcher("/jsps/employeesmenu.jsp").forward(request, response);
		}
	}
}
