package gr.aueb.cf.schoolapp.app;

import java.awt.EventQueue;

import gr.aueb.cf.schoolapp.dao.StudentDAOImpl;
import gr.aueb.cf.schoolapp.dao.TeacherDAOImpl;
import gr.aueb.cf.schoolapp.service.IStudentService;
import gr.aueb.cf.schoolapp.service.ITeacherService;
import gr.aueb.cf.schoolapp.service.StudentServiceImpl;
import gr.aueb.cf.schoolapp.service.TeacherServiceImpl;
import gr.aueb.cf.schoolapp.view.InsertFormTeachers;
import gr.aueb.cf.schoolapp.view.InsertFormStudents;
import gr.aueb.cf.schoolapp.view.Menu;
import gr.aueb.cf.schoolapp.view.SearchFormTeachers;
import gr.aueb.cf.schoolapp.view.SearchFormStudents;
import gr.aueb.cf.schoolapp.view.UpdateDeleteFormTeachers;
import gr.aueb.cf.schoolapp.view.UpdateDeleteFormStudents;

public class TeachersStudentsApp {
	private static Menu menu;
	private static InsertFormTeachers insertFormTeachers;
	private static SearchFormTeachers searchFormTeachers;
	private static UpdateDeleteFormTeachers updateDeleteFormTeachers;
	private static InsertFormStudents insertFormStudents;
	private static SearchFormStudents searchFormStudents;
	private static UpdateDeleteFormStudents updateDeleteFormStudents;
	private static final ITeacherService teacherService = new TeacherServiceImpl(new TeacherDAOImpl());
	private static final IStudentService studentService = new StudentServiceImpl(new StudentDAOImpl());
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					
					menu = new Menu();
					menu.setLocationRelativeTo(null);
					menu.setVisible(true);
					
					insertFormTeachers = new InsertFormTeachers();
					insertFormTeachers.setLocationRelativeTo(null);
					insertFormTeachers.setVisible(false);
					
					updateDeleteFormTeachers = new UpdateDeleteFormTeachers();
					updateDeleteFormTeachers.setLocationRelativeTo(null);
					updateDeleteFormTeachers.setVisible(false);
					
					searchFormTeachers = new SearchFormTeachers();
					searchFormTeachers.setLocationRelativeTo(null);
					searchFormTeachers.setVisible(false);
					
					insertFormStudents = new InsertFormStudents();
					insertFormStudents.setLocationRelativeTo(null);
					insertFormStudents.setVisible(false);
					
					updateDeleteFormStudents = new UpdateDeleteFormStudents();
					updateDeleteFormStudents.setLocationRelativeTo(null);
					updateDeleteFormStudents.setVisible(false);
					
					searchFormStudents = new SearchFormStudents();
					searchFormStudents.setLocationRelativeTo(null);
					searchFormStudents.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	

	public static ITeacherService getTeacherservice() {
		return teacherService;
	}
	

	public static IStudentService getStudentservice() {
		return studentService;
	}


	public static Menu getMenu() {
		return menu;
	}

	public static InsertFormTeachers getInsertFormTeachers() {
		return insertFormTeachers;
	}

	public static SearchFormTeachers getSearchFormTeachers() {
		return searchFormTeachers;
	}

	public static UpdateDeleteFormTeachers getUpdateDeleteFormTeachers() {
		return updateDeleteFormTeachers;
	}

	public static InsertFormStudents getInsertFormStudents() {
		return insertFormStudents;
	}

	public static SearchFormStudents getSearchFormStudents() {
		return searchFormStudents;
	}

	public static UpdateDeleteFormStudents getUpdateDeleteFormStudents() {
		return updateDeleteFormStudents;
	}

}
