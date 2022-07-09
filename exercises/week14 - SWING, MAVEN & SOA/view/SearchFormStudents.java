package gr.aueb.cf.schoolapp.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gr.aueb.cf.schoolapp.app.TeachersStudentsApp;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class SearchFormStudents extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSname;
	private JPanel panel;
	private JButton btnInsert;
	private JPanel panel_1;
	private static String inputLastname;
	private JButton btnNewButton;

	public SearchFormStudents() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SearchFormStudents.class.getClassLoader().getResource("eduv2.png")));
		setTitle("Εισαγωγή / Αναζήτηση Εκπαιδευόμενων");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(415, 429);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 247, 252));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSname = new JLabel("Επώνυμο");
		lblSname.setForeground(new Color(139, 0, 0));
		lblSname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSname.setBounds(153, 29, 98, 20);
		contentPane.add(lblSname);
		
		txtSname = new JTextField();
		txtSname.setBounds(76, 59, 251, 27);
		contentPane.add(txtSname);
		txtSname.setColumns(10);
		
		JButton btnSearch = new JButton("Αναζήτηση");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputLastname = txtSname.getText().trim();
				TeachersStudentsApp.getUpdateDeleteFormStudents().setLastname(inputLastname);
				TeachersStudentsApp.getSearchFormStudents().setEnabled(false);
				TeachersStudentsApp.getUpdateDeleteFormStudents().setVisible(true);
			}
		});
		btnSearch.setForeground(Color.BLUE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(135, 106, 132, 27);
		contentPane.add(btnSearch);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(47, 10, 303, 155);
		contentPane.add(panel);
		
		btnInsert = new JButton("Εισαγωγή");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersStudentsApp.getSearchFormStudents().setEnabled(false);
				TeachersStudentsApp.getInsertFormStudents().setVisible(true);
			}
		});
		btnInsert.setForeground(Color.BLUE);
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnInsert.setBounds(135, 219, 132, 27);
		contentPane.add(btnInsert);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(47, 187, 303, 85);
		contentPane.add(panel_1);
		
		btnNewButton = new JButton("Κλείσιμο");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeachersStudentsApp.getMenu().setEnabled(true);
				TeachersStudentsApp.getSearchFormStudents().setVisible(false);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(245, 311, 105, 45);
		contentPane.add(btnNewButton);
	}

	public static String getInputLastname() {
		return inputLastname;
	}
	
}
