package gr.aueb.cf.schoolapp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gr.aueb.cf.schoolapp.app.TeachersStudentsApp;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Connection conn;

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("AUEB CODING FACTORY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 363);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle1 = new JLabel("Ποιότητα στην Εκπαίδευση");
		lblTitle1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle1.setForeground(new Color(95, 158, 160));
		lblTitle1.setBounds(42, 10, 362, 64);
		contentPane.add(lblTitle1);
		
		JLabel lblTitle2 = new JLabel("Ποιότητα στην Εκπαίδευση");
		lblTitle2.setForeground(new Color(0, 0, 0));
		lblTitle2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle2.setBounds(44, 12, 362, 64);
		contentPane.add(lblTitle2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 84, 400, 1);
		contentPane.add(separator);
		
		JButton btnTeachers = new JButton("");
		btnTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersStudentsApp.getMenu().setEnabled(false);
				TeachersStudentsApp.getSearchFormTeachers().setVisible(true);
			}
		});
		btnTeachers.setBounds(20, 116, 45, 40);
		contentPane.add(btnTeachers);
		
		JButton btnStudents = new JButton("");
		btnStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersStudentsApp.getMenu().setEnabled(false);
				TeachersStudentsApp.getSearchFormStudents().setVisible(true);
			}
		});
		btnStudents.setBounds(20, 190, 45, 40);
		contentPane.add(btnStudents);
		
		JLabel lblTeachers = new JLabel("Εκπαιδευτές");
		lblTeachers.setForeground(new Color(139, 0, 0));
		lblTeachers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTeachers.setBounds(87, 116, 146, 40);
		contentPane.add(lblTeachers);
		
		JLabel lblStudents = new JLabel("Εκπαιδευόμενοι");
		lblStudents.setForeground(new Color(139, 0, 0));
		lblStudents.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudents.setBounds(87, 190, 173, 40);
		contentPane.add(lblStudents);
	}

	public static Connection getConn() {
		return conn;
	}
}
