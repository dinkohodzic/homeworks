package ba.bitcamp.homework.task1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 * Application that records customers complaints.
 * @author Dinko Hodzic
 *
 */
public class InputComplaints extends JFrame{

	private static final long serialVersionUID = 5202058449621345386L;
	private JTextField field = new JTextField();
	private JButton btnSubmit = new JButton("Submit");

	private Connection conn;
	
	/**
	 * Default constructor.
	 */
	public InputComplaints() {
		
		setLayout(new BorderLayout());
		
		connectToDB();
		
		field.addKeyListener(new Action());
		btnSubmit.addActionListener(new Action());
		
		add(field);
		add(btnSubmit, BorderLayout.SOUTH);
		
		setTitle("Insert complaint");
		setSize(400, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class Action extends KeyAdapter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			insertValue();
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				insertValue();
			}
		}
	}
	
	/**
	 * This method adds a new complaint to the database
	 */
	private void insertValue() {
		try {
			Complaint complaint = new Complaint(field.getText(), Calendar.getInstance());
			field.setText("");
			
			Statement statement = conn.createStatement();
			
			String c = "INSERT INTO complaint VALUES(" + complaint.getId() + ", '" + complaint.getMessage() + "', '" + complaint.getDate() + "', '" + complaint.getTime() + "')";
			
			statement.executeUpdate(c);
		} catch (SQLException e) {
			System.err.println("Bad SQL Command.");
			System.out.println("Continuing ...");
		}
	}
	
	/**
	 * This method establishes a connection to the database
	 */
	private void connectToDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Library loaded.");
			
			conn = DriverManager.getConnection("jdbc:sqlite:base/complaint.db");
			System.out.println("Connection established.");			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC library is not loaded.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		} catch (SQLException e) {
			System.err.println("Could not connect to the database.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		
	}
	
	public static void main(String[] args) {
		new InputComplaints();
	}
	
}
