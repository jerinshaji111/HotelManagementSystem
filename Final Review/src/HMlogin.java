package seProject;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class HMlogin extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Employee Name");
	private JTextField textField;
	private JTextField textField_1;
	Connection connect = null;

	/**
	 * Launch the application.
	 */
HMlogin() {
		setType(Type.UTILITY);
		setTitle("HM Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(31, 76, 126, 36);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(197, 85, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(36, 154, 56, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(197, 151, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value1=textField.getText();
    	  		String value2=textField_1.getText();
    	  		String pass = null;
    	  		try {
    	  			Class.forName("org.postgresql.Driver");
    		        connect = DriverManager
    		            .getConnection("jdbc:postgresql://localhost:5432/hotelmanagementsystem",
    		            "postgres", "password");
    		        Statement statement = connect.createStatement();
    		        PreparedStatement st = connect.prepareStatement("select * from EMP where name=?");  
    		        st.setString(1, value1);
    		        ResultSet resultSet = st.executeQuery();
    		        if(resultSet.next())
    		        {
    		            pass = resultSet.getString(2);
    		        }
    		        //System.out.println(pass);
    		        if (value2.equals(pass)) {
    		        	dispose();
    					HotelManagemnt hmm = new HotelManagemnt();
    					hmm.setVisible(true);
    		  		}
    		  		else{
    		  			System.out.println("enter the valid username and password");
    		  			JOptionPane.showMessageDialog(null,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
    		  		}
    		        
    	  		}
    	  		catch (Exception a) 
    			{
    	  			System.out.println("Error");
    		        System.out.println(a.getMessage());
    		    }
				
				
				
				
				
				
			}
			
		});
		btnNewButton.setBounds(219, 212, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Login l = new Login();
				l.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(83, 212, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
