package ba.bitcamp.flappyBird;

import javax.swing.JFrame;

public class Main extends JFrame {

	
	private static final long serialVersionUID = -4738949043229487125L;
	public static JFrame window = new JFrame();
	
	
	public Main() {
	
		FlappyBlock flappyblock = new FlappyBlock();
		
		window.setContentPane(flappyblock);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1200, 800);

		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public static void restart(){
		main(null);
	}
	
}
