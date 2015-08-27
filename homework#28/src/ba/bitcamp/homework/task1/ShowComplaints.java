package ba.bitcamp.homework.task1;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JTextArea;
/**
 * Application that displays customers complaints.
 * @author Dinko Hodzic
 *
 */
public class ShowComplaints extends JFrame{
	
	private static final long serialVersionUID = -7653705490290571579L;

	private JTextArea area = new JTextArea();
	
	private ArrayList<Complaint> list = new ArrayList<Complaint>();

	private Connection conn;
	
	/**
	 * Default constructor.
	 */
	public ShowComplaints() {
		
		setLayout(new BorderLayout());
		
		connectToDB();
		
		
		getComplaints();
		
		setTextArea();
		
		area.setEditable(false);
		add(area);
		
		setTitle("Complaints");
		setSize(640, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Adds a complaint to the JTextArea
	 */
	private void setTextArea() {
		for (Complaint c : list) {
			String line = c.getId() + " - " + c.getMessage() + " - " + c.getTime() + " " + c.getDate() + "\n";
			area.setText(area.getText() + line);
		}
		
	}

	private void getComplaints() {
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM complaint");
		
			while (result.next()) {	
				
				int id = result.getInt(1);
				String msg = result.getString(2);
				String date = result.getString(3);
				String time = result.getString(4);
				
				int day = Integer.parseInt(date.split("-")[2]);
				int month = Integer.parseInt(date.split("-")[1]);
				int year = Integer.parseInt(date.split("-")[0]);
				int hour = Integer.parseInt(time.split("-")[0]);
				int min = Integer.parseInt(time.split("-")[1]);
				Calendar cal = new GregorianCalendar(year, month, day, hour, min);
				
				Complaint c = new Complaint(id, msg, cal);
				
				list.add(c);
			}
		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
	}
	
	/**
	 * This method establishes a connection to the database
	 */
	private void connectToDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Library loaded succesfully.");
			
			conn = DriverManager.getConnection("jdbc:sqlite:base/complaint.db");
			System.out.println("Connection established.");			
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC library is not loaded.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		} catch (SQLException e) {
			System.err.println("Unable to connect to the database.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		
	}
	
	public static void main(String[] args) {
		new ShowComplaints();
	}
	
}
