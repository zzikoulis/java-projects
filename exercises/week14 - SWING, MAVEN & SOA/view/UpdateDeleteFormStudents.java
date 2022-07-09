package gr.aueb.cf.schoolapp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gr.aueb.cf.schoolapp.app.TeachersStudentsApp;
import gr.aueb.cf.schoolapp.dto.StudentDTO;
import gr.aueb.cf.schoolapp.model.Student;
import gr.aueb.cf.schoolapp.service.IStudentService;
import gr.aueb.cf.schoolapp.service.exceptions.StudentNotFoundException;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateDeleteFormStudents extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtSname;
	private JTextField txtFname;
	private String lastname;
	private List<Student> students;
	private int listPosition;
	private int listSize;
	private final IStudentService studentService = TeachersStudentsApp.getStudentservice();

	public UpdateDeleteFormStudents() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				try {
					students = studentService.getStudentsByLastname(lastname);
					
					if (students != null) {
						listPosition = 0;
						listSize = students.size();
						
						txtId.setText(String.format("%s",students.get(listPosition).getId()));
						txtSname.setText(students.get(listPosition).getSname());
						txtFname.setText(students.get(listPosition).getFname());
					} else {
						JOptionPane.showMessageDialog(null, "Students not found", "Empty Search", JOptionPane.PLAIN_MESSAGE);
						TeachersStudentsApp.getSearchFormStudents().setEnabled(true);
						TeachersStudentsApp.getUpdateDeleteFormStudents().setVisible(false);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Please try again", "Error", JOptionPane.WARNING_MESSAGE);
					TeachersStudentsApp.getSearchFormStudents().setEnabled(true);
					TeachersStudentsApp.getUpdateDeleteFormStudents().setVisible(false);
				} 
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				txtId.setText("");
				txtSname.setText("");
				txtFname.setText("");
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateDeleteFormStudents.class.getClassLoader().getResource("eduv2.png")));
		setTitle("Ενημέρωση / Διαγραφή Εκπαιδευόμενου");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 311);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Κωδικός");
		lblId.setForeground(new Color(139, 0, 0));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblId.setBounds(34, 28, 67, 27);
		contentPane.add(lblId);
		
		JLabel lblSname = new JLabel("Επώνυμο");
		lblSname.setForeground(new Color(139, 0, 0));
		lblSname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSname.setBounds(34, 65, 73, 27);
		contentPane.add(lblSname);
		
		JLabel lblNFname = new JLabel("Όνομα");
		lblNFname.setForeground(new Color(139, 0, 0));
		lblNFname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNFname.setBounds(34, 102, 67, 27);
		contentPane.add(lblNFname);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(135, 28, 67, 19);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtSname = new JTextField();
		txtSname.setColumns(10);
		txtSname.setBounds(135, 65, 164, 19);
		contentPane.add(txtSname);
		
		txtFname = new JTextField();
		txtFname.setColumns(10);
		txtFname.setBounds(135, 102, 164, 19);
		contentPane.add(txtFname);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 139, 380, 6);
		contentPane.add(separator);
		
		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						listPosition = 0;
						txtId.setText(String.format("%s",students.get(listPosition).getId()));
						txtSname.setText(students.get(listPosition).getSname());
						txtFname.setText(students.get(listPosition).getFname());
			}
		});
		btnFirst.setIcon(new ImageIcon(UpdateDeleteFormStudents.class.getClassLoader().getResource("First record.png")));
		btnFirst.setBounds(115, 155, 38, 32);
		contentPane.add(btnFirst);
		
		JButton btnPrevious = new JButton("");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (listPosition > 0) {
						listPosition--;
						txtId.setText(String.format("%s",students.get(listPosition).getId()));
						txtSname.setText(students.get(listPosition).getSname());
						txtFname.setText(students.get(listPosition).getFname());
					} else {
						JOptionPane.showMessageDialog(null, "No previous student in the list", "Info", JOptionPane.PLAIN_MESSAGE);
					}
			}
		});
		btnPrevious.setIcon(new ImageIcon(UpdateDeleteFormStudents.class.getClassLoader().getResource("Previous_record.png")));
		btnPrevious.setBounds(151, 155, 38, 32);
		contentPane.add(btnPrevious);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (listPosition < listSize -1) {
						listPosition++;
						txtId.setText(String.format("%s",students.get(listPosition).getId()));
						txtSname.setText(students.get(listPosition).getSname());
						txtFname.setText(students.get(listPosition).getFname());
					} else {
						JOptionPane.showMessageDialog(null, "No next student in the list", "Info", JOptionPane.PLAIN_MESSAGE);
					}
			}
		});
		btnNext.setIcon(new ImageIcon(UpdateDeleteFormStudents.class.getClassLoader().getResource("Next_track.png")));
		btnNext.setBounds(187, 155, 38, 32);
		contentPane.add(btnNext);
		
		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						listPosition = listSize - 1;
						txtId.setText(String.format("%s",students.get(listPosition).getId()));
						txtSname.setText(students.get(listPosition).getSname());
						txtFname.setText(students.get(listPosition).getFname());
			}
		});
		btnLast.setIcon(new ImageIcon(UpdateDeleteFormStudents.class.getClassLoader().getResource("Last_Record.png")));
		btnLast.setBounds(221, 155, 38, 32);
		contentPane.add(btnLast);
		
		JButton btnDelete = new JButton("Διαγραφή");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 StudentDTO studentToDelete = new StudentDTO();
					 studentToDelete.setId(students.get(listPosition).getId());
					 studentToDelete.setSname(students.get(listPosition).getSname());
					 studentToDelete.setFname(students.get(listPosition).getFname());
					
					int answer = JOptionPane.showConfirmDialog(null, "Είστε σίγουρος;", "Warning", JOptionPane.YES_NO_OPTION);
					if (answer == JOptionPane.YES_OPTION) {
						studentService.deleteStudent(studentToDelete);
						JOptionPane.showMessageDialog(null, "Deleted successfully", "DELETE", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Please try again", "Error", JOptionPane.WARNING_MESSAGE);
				} catch (StudentNotFoundException e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Student not found", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(34, 211, 116, 42);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Μεταβολή");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StudentDTO oldStudentDTO = new StudentDTO();
					StudentDTO newStudentDTO = new StudentDTO();
					
					oldStudentDTO.setId(students.get(listPosition).getId());
					
					newStudentDTO.setId(students.get(listPosition).getId());
					newStudentDTO.setSname(txtSname.getText().trim());
					newStudentDTO.setFname(txtFname.getText().trim());
					
					int answer = JOptionPane.showConfirmDialog(null, "Είστε σίγουρος;", "Warning", JOptionPane.YES_NO_OPTION);
					if (answer == JOptionPane.YES_OPTION) {
						studentService.updateStudent(oldStudentDTO, newStudentDTO);
						JOptionPane.showMessageDialog(null, "Updated successfully", "UPDATE", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Please try again", "Error", JOptionPane.WARNING_MESSAGE);
				} catch (StudentNotFoundException e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Student not found", "Error", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(148, 211, 116, 42);
		contentPane.add(btnUpdate);
		
		JButton btnClose = new JButton("Κλείσιμο");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersStudentsApp.getSearchFormStudents().setEnabled(true);
				TeachersStudentsApp.getUpdateDeleteFormStudents().setVisible(false);
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClose.setBounds(261, 211, 116, 42);
		contentPane.add(btnClose);
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
