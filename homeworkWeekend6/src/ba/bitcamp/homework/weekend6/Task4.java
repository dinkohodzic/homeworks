package ba.bitcamp.homework.weekend6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task4 extends JFrame {

	private static final long serialVersionUID = -7030811888512223030L;
	//Initializing attributes
	private JButton button1 = new JButton("Char: ");
	private JButton button2 = new JButton("Insert");
	private JButton button3 = new JButton(">");
	private JButton button4 = new JButton("<");
	private String s = "";
	private String[] array = { "a", "b", "c", "d", "e", "f", "g", "h", "i",
			"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z" };
	private JLabel label = new JLabel("_");

	public Task4() {
		//Initializing and setting the layout
		BorderLayout layout = new BorderLayout();
		setLayout(new BorderLayout());
		//Initializing and setting the buttons
		add(button1, BorderLayout.NORTH);
		button1.addActionListener(new Action());
		add(button2, BorderLayout.SOUTH);
		button2.addActionListener(new Action());
		add(button3, BorderLayout.EAST);
		button3.addActionListener(new Action());
		add(button4, BorderLayout.WEST);
		button4.addActionListener(new Action());
		label.setHorizontalAlignment(NORMAL);
		add(label, BorderLayout.CENTER);
		
		
		setTitle("Task4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button1) {
				button1.setText("Char: "+(array[(int) (Math.random() * array.length)]));
				
			} else if (e.getSource() == button2) {
				int temp = label.getText().indexOf("_");
				s = label.getText().substring(0, temp);
				s += button1.getText().substring(6);
				s += "_";
				s += label.getText().substring(temp + 1,
						label.getText().length());
				label.setText(s);
			} else if (e.getSource() == button3) {
				int temp = label.getText().indexOf("_");

				s = label.getText().substring(0, temp);
				s += label.getText().substring(temp + 1, temp + 2) + "_";
				s += label.getText().substring(temp + 2,
						label.getText().length());
				label.setText(s);

			} else if (e.getSource() == button4) {
				int temp = label.getText().indexOf("_");

				s = label.getText().substring(0, temp - 1);
				s += "_";
				s += label.getText().substring(temp - 1, temp);
				s += label.getText().substring(temp + 1,
						label.getText().length());
				label.setText(s);

			}
		}

	}

	public static void main(String[] args) {
		new Task4();
	}

}
