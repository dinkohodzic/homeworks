package ba.bitcamp.homework.weekend6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task1 extends JFrame {
	//Initializing attributes
	private JButton[] buttons = new JButton[10];
	private int counter = 0;
	private String sum = "";
	private static final long serialVersionUID = -3886179898710429771L;
	
	public Task1() {
		//Setting the layout
		setLayout(new GridLayout(10, 1));
		//filling the layout with buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton((i) + "");
			buttons[i].addActionListener(new Action());
			add(buttons[i]);
			
			setTitle("Task1");
			setSize(200, 400);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
		}
	}

	private class Action implements ActionListener {
		/**
		 * 
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					counter++;
					sum += (buttons[i].getText()) + "";
				}
				if (counter == 3) {

					JOptionPane.showMessageDialog(null, "Number: " + sum);
					sum="";
					counter = 0;
				}
			}
		}

	}

	public static void main(String[] args) {
		new Task1();

	}

}
