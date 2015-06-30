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
	private FirstName firstName = new FirstName();
	private LastName lastName = new LastName();

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
		private static String firstName;
		private final static String[] firstNames = { "John", "George", "Oscar",
				"Natalie", "Susan" };

		public FirstName() {
			firstName = null;
		}

		/**
		 * Generates a random first name
		 * 
		 * @return The character
		 */
		public void generateName() {
			firstName = ""
					+ firstNames[(int) (Math.random() * firstNames.length)];

		}

		public String toString() {
			return firstName;
		}
	}

	private static class LastName {
		private  static String lastName;
		private final static String[] lastNames = { "Jones", "Wild", "Martin",
				"Roberts", "Clinton" };

		public LastName() {
			lastName = null;
		}

		/**
		 * Generates a random last name
		 * 
		 * @return The character
		 */
		public void generateLastName() {
			lastName = "" + lastNames[(int) (Math.random() * lastNames.length)];
			;

		}

		public String toString() {
			return lastName;
		}
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				 firstName.generateName();
			} else if (e.getSource() == button2) {
				lastName.generateLastName();
			}
			label.setText(firstName + " " + lastName);
		}

	}

	public static void main(String[] args) {
		new Task2();
	}

}
