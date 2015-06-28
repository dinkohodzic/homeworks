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
	//Initializing attributes
	private JButton[] buttons1 = new JButton[5];
	private JButton[] buttons2 = new JButton[5];
	public String[] array = new String[5];

	public Task3() {
		
		//Initializing and setting the layout
		GridLayout layout = new GridLayout();
		setLayout(new GridLayout(2, 5));
		
		for (int i = 0; i < buttons1.length; i++) {
			buttons1[i] = new JButton(Integer.toString(i));
			add(buttons1[i]);
			buttons1[i].addActionListener(new Action());
		}
		
		for (int i = 0; i < buttons2.length; i++) {

			buttons2[i] = new JButton(Integer.toString(i + 5));
			add(buttons2[i]);
			buttons2[i].addActionListener(new Action());
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
			for (int i = 0; i < buttons1.length; i++) {
				if (e.getSource() == buttons1[i]) {
					buttons1[i].setEnabled(false);
					array[i] = buttons1[i].getText();
				} else if (e.getSource() == buttons2[i]) {
					buttons2[i].setEnabled(false);
					array[i] = buttons2[i].getText();
				}
			}
			if (array[4] != null) {
				JOptionPane.showMessageDialog(null, Arrays.toString(array));
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		new Task3();
	}

}
