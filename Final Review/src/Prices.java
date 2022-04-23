package seProject;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class Prices {
	// frame
	JFrame f;
	// Table
	JTable j;

	// Constructor
	Prices()
	{
		// Frame initialization
		f = new JFrame();

		// Frame Title
		f.setTitle("Price Table");

		// Data to be displayed in the JTable
		String[][] data = {
			{ "VIP Suite", "1600"},
			{ "Deluxe", "1200"},
			{ "Family", "1000"},
			{ "Regular", "500"},
		};

		// Column Names
		String[] columnNames = { "Room Type", "Pricing(Per Night/-)" };

		// Initializing the JTable
		j = new JTable(data, columnNames);
		j.setFont(new Font("Tahoma", Font.PLAIN, 12));
		j.setBackground(new Color(204, 153, 153));
		j.setBounds(100,200, 100, 200);

		// adding it to JScrollPane
		JScrollPane sp = new JScrollPane(j);
		f.getContentPane().add(sp);
		// Frame Size
		f.setSize(633, 406);
		// Frame Visible = true
		f.setVisible(true);
		
	}

	// Driver method
	public static void main(String[] args)
	{
		new Prices();
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
