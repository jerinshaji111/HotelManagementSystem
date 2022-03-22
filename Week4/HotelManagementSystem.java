package demodb;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class HotelManagementSystem extends JFrame implements ActionListener{
	
	HotelManagementSystem(){
		setBounds(300,130,900,600);
		
		ImageIcon i1 = new ImageIcon();
		JLabel l1 = new JLabel(i1);
		l1.setBounds(0,0,900,600);
		add(l1);
		
		JLabel l2 = new JLabel("Welcome to abc");
		l2.setBounds(150,65,1000,70);
		l2.setFont(new Font("serif",Font.PLAIN,60));
		l2.setForeground(Color.red);
		l1.add(l2);
		
		
		JButton b1 = new JButton("Management");
		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b1.setBounds(400,150,180,50);
		b1.addActionListener(this);
		l1.add(b1);
		
		
		JButton b2 = new JButton("Book Room");
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b2.setBounds(400,250,180,50);
		b2.addActionListener(this);
		l1.add(b2);
		
		setLayout(null);
		setVisible(true);

		
	}
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1)
		{
			frame.dispose();
			Admin r=new Admin();
		}
		else if(e.getSource()== b2)
		{
			frame.dispose();
			Login r=new Login();

		}
		}
	


	public static void main(String[] args) {
		
		new HotelManagementSystem();
		
	}

}
