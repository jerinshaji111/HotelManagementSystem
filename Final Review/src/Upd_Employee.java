package seProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Upd_Employee extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Name");
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	Upd_Employee() {
		setType(Type.UTILITY);
		setTitle("Hotel Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 509);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Update");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Rooms");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				HotelManagemnt h = new HotelManagemnt();
				h.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Employee");
		mntmNewMenuItem_1.setSelected(true);
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setBounds(25, 55, 126, 36);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(140, 64, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 124, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(99, 340, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Salary");
		lblNewLabel_1.setBounds(25, 121, 64, 19);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBounds(270, 64, 564, 297);
		contentPane.add(table);
	}
}
