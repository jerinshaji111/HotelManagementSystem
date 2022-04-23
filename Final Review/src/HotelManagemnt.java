package seProject;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Window.Type;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class HotelManagemnt extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Room");
	private JTextField textField;
	private JTable table;
	private JComboBox comboBox;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	 HotelManagemnt() {
		setType(Type.UTILITY);
		setTitle("Hotel Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 509);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Update ");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Rooms");
		mntmNewMenuItem.setSelected(true);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Employee");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Upd_Employee emp = new Upd_Employee();
				emp.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(25, 55, 72, 36);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(140, 125, 85, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Set Quantity");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(25, 125, 85, 13);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 64, 564, 143);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"VIP Suite", "Deluxe ", "Family(3B)","Regular(2B)"}));
		comboBox.setBounds(140, 63, 85, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("AC");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(25, 182, 60, 13);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 179, 85, 19);
		contentPane.add(textField_1);
		
		try {
	        Class.forName("org.postgresql.Driver");
	        Connection connect = DriverManager
                    .getConnection("jdbc:postgresql://localhost/hotelmanagementsystem",
                            "postgres", "password");
	        if (connect!=null) {
	        	System.out.println("connection established");
	        }
	        Statement statement = connect.createStatement();
	        PreparedStatement st = connect.prepareStatement("select * from HMS_RB");  
	        ResultSet rs = st.executeQuery();
	        table.setModel(DbUtils.resultSetToTableModel(rs));
	        }
  		catch (Exception a) 
		{
	        System.out.println(a.getMessage());
	    }
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String room = (String) comboBox.getSelectedItem();
				int qnty = Integer.parseInt(textField.getText());
				String ac = textField_1.getText();
				
				try
				{
					Class.forName("org.postgresql.Driver");  
		            Connection con = DriverManager
		                    .getConnection("jdbc:postgresql://localhost/hotelmanagementsystem",
		                            "postgres", "password");
		            PreparedStatement st1 = con.prepareStatement("update HMS_RB set Quantity=?, AC=? where Room_Type =?");  
		            
		            st1.setInt(1,qnty);
		            st1.setString(2,ac);
		            st1.setString(3,room);
		            st1.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Updated successfully", "Success", JOptionPane.PLAIN_MESSAGE);
		            dispose();
					HotelManagemnt hmm = new HotelManagemnt();
					hmm.setVisible(true);
		            
				}
				catch(Exception z)
				{
					System.out.println(z.getMessage());
				}
			}
		});
		btnNewButton.setBounds(99, 340, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Login l = new Login();
				l.setVisible(true);
				
			}
		});
		btnLogout.setBounds(270, 340, 107, 21);
		contentPane.add(btnLogout);
		
		
		
		
	}
}
