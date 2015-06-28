package ba.bitcamp.homework.weekend6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task2 extends JFrame {
	// Initializing attributes
	private JButton button1 = new JButton("First Name");
	private JButton button2 = new JButton("Last Name");
	private JLabel label = new JLabel("Name  LName");
	public static String characters = "ABCDEFGHIJKLMNOPRSTUVZ";

	private static final long serialVersionUID = 2888620759776532509L;

	public Task2() {
		// Initializing and setting the layout
		BorderLayout layout = new BorderLayout();
		setLayout(new BorderLayout());

		add(button1, BorderLayout.WEST);
		button1.addActionListener(new Action());

		add(button2, BorderLayout.EAST);
		button2.addActionListener(new Action());

		label.setHorizontalAlignment(NORMAL);
		add(label, BorderLayout.CENTER);

		setTitle("Task2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private static class FirstName {
		public static String name = "Name";
		
		/**
		 * Generates a random character for the first name
		 * @return The character
		 */
		public static String generateName() {
			String randomName = name
					+ characters.charAt((int) (Math.random() * characters
							.length()));
			return randomName;
		}
	}

	private static class LastName {
		public static String lastName = "LName";
		
		/**
		 * Generates a random character for the last name
		 * @return The character
		 */
		public static String generateLastName() {
			String randomLastName = lastName
					+ characters.charAt((int) (Math.random() * characters
							.length()));
			return randomLastName;
		}
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				String s = FirstName.generateName()
						+ label.getText().substring(5);
				label.setText(s);
			} else if (e.getSource() == button2) {
				String s = label.getText().substring(0, 6)
						+ LastName.generateLastName();
				label.setText(s);
			}

		}

	}

	public static void main(String[] args) {
		new Task2();
	}

}
