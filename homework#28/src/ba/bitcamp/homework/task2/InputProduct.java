package ba.bitcamp.homework.task2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Application that inserts products into database.
 * @author Dinko Hodzic
 *
 */
public class InputProduct extends JFrame{
	
	private static final long serialVersionUID = -8905164783683527667L;
	private JLabel idLabel = new JLabel("Code:");
	private JTextField idField = new JTextField();
	private JLabel nameLabel = new JLabel("Name:");
	private JTextField nameField = new JTextField();
	private JLabel priceLabel = new JLabel("Price:");
	private JTextField priceField = new JTextField();
	private JPanel mainPanel = new JPanel();
	private JButton submitButton = new JButton("Submit");

	private Connection conn;
	
	/**
	 * Default constructor.
	 */
	public InputProduct() {
		
		setLayout(new BorderLayout());
		mainPanel.setLayout(new GridLayout(3, 2));
		
		
		
		establishConnectionToDB();
		
		submitButton.addActionListener(new Action());
		
		mainPanel.add(idLabel);
		mainPanel.add(idField);
		mainPanel.add(nameLabel);
		mainPanel.add(nameField);
		mainPanel.add(priceLabel);
		mainPanel.add(priceField);
		
		add(mainPanel);
		add(submitButton, BorderLayout.SOUTH);
		
		setTitle("Insert product");
		setSize(400, 200);
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
	
	private void insertValue() {
		try {
			String id = idField.getText();
			if(id.length() != 10) {
				JOptionPane.showMessageDialog(null, "Incorrect code: There must be 10 digits in id");
				return;
			}
			for (char c : id.toCharArray()) {
				if (!Character.isDigit(c)){
					JOptionPane.showMessageDialog(null, "Incorrect code: All characters must be digits");
					return;
				}
			}
			if (codeExists(id)) {
				JOptionPane.showMessageDialog(null, "Incorrect code: Code already exists");
				return;
			}
			String name = nameField.getText();
			if (nameExists(name)) {
				int option = JOptionPane.showConfirmDialog(null, "Name already exists. Do you want do set another name?");
				if (option == JOptionPane.YES_OPTION) 
					return;
			}
			BigDecimal price = null; 
			try {
				price = new BigDecimal(priceField.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Incorrect price");
				return;
			}
			Product p = new Product(id, name, price);
			idField.setText("");
			nameField.setText("");
			priceField.setText("");
			
			Statement statement = conn.createStatement();
			
			String c = "INSERT INTO product VALUES(" + p.getId() + ", '" + p.getName() + "', '" + p.getPrice() + "')";
			
			statement.executeUpdate(c);
		} catch (SQLException e) {
			System.out.println("Bad SQL Command.");
			System.out.println("Continuing on.");
		}
	}
	
	/**
	 * Checks if a name already exists in the database
	 * @param name The name
	 * @return true if the name already exists, otherwise returns false
	 */
	private boolean nameExists(String name) {
		try {
			Statement statement = conn.createStatement();
			String c = "SELECT * FROM product WHERE name = '" + name + "'";
			ResultSet result = statement.executeQuery(c);
			if (result.next()) 
				return true;
			
		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		return false;
	}
	
	/**
	 * Checks if an id already exists in the database
	 * @param id The id
	 * @return true if the id already exists, otherwise returns false
	 */
	private boolean codeExists(String id) {
		try {
			Statement statement = conn.createStatement();
			String c = "SELECT * FROM product WHERE id = " + id;
			ResultSet result = statement.executeQuery(c);
			if (result.next()) 
				return true;
			
		} catch (SQLException e) {
			System.err.println("Bad SQL command.");
			System.err.println("Msg: " + e.getMessage());
			System.exit(1);
		}
		return false;
	}

	/**
	 * This method establishes a connection to the database
	 */
	private void establishConnectionToDB() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Library loaded.");
			
			conn = DriverManager.getConnection("jdbc:sqlite:base/product.db");
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
		new InputProduct();
	}
	
}
