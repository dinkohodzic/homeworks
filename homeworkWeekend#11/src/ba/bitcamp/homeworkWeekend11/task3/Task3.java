package ba.bitcamp.homeworkWeekend11.task3;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task3 extends JFrame {

	private static final long serialVersionUID = 1031195880481379663L;

	private JButton button = new JButton();
	private JLabel label = new JLabel();

	static StringBuilder sb = new StringBuilder();
	
	Thread t = new Thread(new MyThread());
	
	public Task3() {

		setLayout(new BorderLayout());
		t.start();
		add(button, BorderLayout.SOUTH);
		button.setText("STOP");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					t.interrupt();
				}

			}
		});

		add(label, BorderLayout.CENTER);
		label.setFont(new Font("Calibri", Font.BOLD, 16));

		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		label.setText(sb.toString());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 100);
		setVisible(true);

	}

	static class MyThread implements Runnable {
		char[] chars = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		@Override
		public void run() {
			
			for (int i = 0; i < chars.length; i++) {
				sb.append(chars[i] + " ");
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new Task3();
	}

}
