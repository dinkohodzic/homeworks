package ba.bitcamp.homework.weekend6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task3 extends JFrame {

	private static final long serialVersionUID = -529844628083615961L;
	// Initializing attributes
	private JButton[] buttons = new JButton[10];
	private Integer[] array = new Integer[buttons.length / 2];
	private Integer counter = 0;

	public Task3() {

		// Initializing and setting the layout
		setLayout(new GridLayout(2, 5));

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("" + i);
			buttons[i].addActionListener(new Action());
			add(buttons[i]);
		}

		setTitle("Task3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(600, 100);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < buttons.length; i++) {
				if (buttons[i] == e.getSource() && array[i % 5] == null) {
					buttons[i].setEnabled(false);
					array[i % 5] = i;
					counter++;

					if (counter == array.length) {
						JOptionPane.showMessageDialog(null,
								Arrays.toString(array));
						System.exit(0);
					}

				}

			}
		}
	}

	public static void main(String[] args) {
		new Task3();
	}

}
