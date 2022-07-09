package gr.aueb.cf.schoolapp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gr.aueb.cf.schoolapp.app.TeachersStudentsApp;
import gr.aueb.cf.schoolapp.dto.StudentDTO;
import gr.aueb.cf.schoolapp.service.IStudentService;
import gr.aueb.cf.schoolapp.service.exceptions.StudentIdAlreadyExistsException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertFormStudents extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSname;
	private JTextField txtFname;
	private final IStudentService studentService = TeachersStudentsApp.getStudentservice();

	public InsertFormStudents() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtSname.setText("");
				txtFname.setText("");
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(InsertFormStudents.class.getClassLoader().getResource("eduv2.png")));
		setTitle("Εισαγωγή Εκπαιδευόμενου");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 312);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSname = new JLabel("Επώνυμο");
		lblSname.setForeground(new Color(139, 0, 0));
		lblSname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSname.setBounds(80, 33, 86, 35);
		contentPane.add(lblSname);
		
		JLabel lblFname = new JLabel("Όνομα");
		lblFname.setForeground(new Color(139, 0, 0));
		lblFname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFname.setBounds(80, 88, 68, 45);
		contentPane.add(lblFname);
		
		txtSname = new JTextField();
		txtSname.setBounds(176, 38, 155, 25);
		contentPane.add(txtSname);
		txtSname.setColumns(10);
		
		txtFname = new JTextField();
		txtFname.setBounds(176, 98, 155, 25);
		contentPane.add(txtFname);
		txtFname.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 155, 393, 2);
		contentPane.add(separator);
		
		JButton btnInsert = new JButton("Εισαγωγή");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if (txtSname.getText().trim().equals("") || txtFname.getText().trim().equals("")) {
				
						JOptionPane.showMessageDialog(null,"Not valid input", "Error", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					
					StudentDTO studentDTO = new StudentDTO();
					studentDTO.setSname(txtSname.getText().trim());
					studentDTO.setFname(txtFname.getText().trim());
					
					studentService.insertStudent(studentDTO);
					JOptionPane.showMessageDialog(null,"Inserted Successfull", "INSERT", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Something went wrong with insertion, please try again", "INSERT", JOptionPane.WARNING_MESSAGE);
				} catch (StudentIdAlreadyExistsException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInsert.setForeground(new Color(0, 0, 255));
		btnInsert.setBounds(129, 206, 140, 35);
		contentPane.add(btnInsert);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(58, 21, 313, 124);
		contentPane.add(panel);
		
		JButton btnClose = new JButton("Κλείσιμο");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersStudentsApp.getSearchFormStudents().setEnabled(true);
				TeachersStudentsApp.getInsertFormStudents().setVisible(false);
			}
		});
		btnClose.setForeground(Color.BLUE);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnClose.setBounds(276, 206, 140, 35);
		contentPane.add(btnClose);
	}
}
