package seProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Window.Type;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;

public class RoomBooking extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Name");
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomBooking frame = new RoomBooking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RoomBooking() {
		setType(Type.UTILITY);
		setTitle("RoomBooking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 52, 126, 36);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(181, 61, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Aadhar id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 137, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(181, 134, 96, 19);
		contentPane.add(textField_1);
		lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(28, 205, 57, 19);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 205, 96, 19);
		contentPane.add(textField_2);
		
		lblNewLabel_3 = new JLabel("Room");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(28, 280, 57, 13);
		contentPane.add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"VIP Suite", "Deluxe ", "Family(3B)","Regular(2B)"}));
		comboBox.setBounds(180, 276, 85, 21);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
		  		String aadhar=textField_1.getText();
		  		String email=textField_2.getText();
		  		String roomtype = (String) comboBox.getSelectedItem();
		  		
		  		if(name.equals("") || aadhar.equals("") || email.equals("") )
		        {
		        	JOptionPane.showMessageDialog(null, "All fields must be complete to submit.", "Woops", JOptionPane.ERROR_MESSAGE);
		            return ;
		        }
		  		try
				{
					Class.forName("org.postgresql.Driver");  
		            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/hotelmanagementsystem",
                            "postgres", "password");
		            PreparedStatement st1 = con.prepareStatement("insert into RB values (?,?,?,?)");  
		            st1.setString(1,name);
		            st1.setInt(2,Integer.parseInt(aadhar));
		            st1.setString(3,email);
		            st1.setString(4,roomtype);
		            st1.executeUpdate();
		            
		            /*
		            int qnty = 0;
		            PreparedStatement st2 = con.prepareStatement("select * from HMS_RB where Room_Type=?");  
    		        st2.setString(1, roomtype);
    		        ResultSet resultSet = st2.executeQuery();
    		        if(resultSet.next())
    		        {
    		            qnty = resultSet.getInt(2);
    		        }
    		        
    		        //System.out.println(qnty);
    		        
		            int updqnty=qnty-1;
		            PreparedStatement st3 = con.prepareStatement("update HMS_RB set Quantity=? Room_Type =?");
		            st1.setInt(1,updqnty);
		            st1.setString(2,roomtype);
		            st1.executeUpdate();
		            */
		            
		            JOptionPane.showMessageDialog(null, "Payment Successful", "Success", JOptionPane.PLAIN_MESSAGE);
					dispose();
					Login l = new Login();
					l.setVisible(true);
				}
				catch(Exception z)
				{
					System.out.println(z.getMessage());
				}		

			}
		});
		btnNewButton.setBounds(236, 368, 85, 21);
		contentPane.add(btnNewButton);
		
		
	}

}
