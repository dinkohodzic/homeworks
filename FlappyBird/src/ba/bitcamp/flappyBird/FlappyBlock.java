package ba.bitcamp.flappyBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class FlappyBlock implements ActionListener, MouseListener, KeyListener {

	public static FlappyBlock flappyBlock;

	public final int WINDOW_WIDTH = 1200;
	public final int WINDOW_HEIGHT = 800;
	private Rectangle block;

	private Rectangle cloud1;
	private Rectangle cloud2;
	private Rectangle cloud3;
	private Rectangle cloud4;

	private Rectangle t1;
	private Rectangle t2;
	private Rectangle t3;
	private Rectangle t4;
	private Rectangle t5;
	private Rectangle t6;
	private Rectangle t7;
	private Rectangle t8;
	private Rectangle t9;

	private BufferedImage bird;

	private BufferedImage clouds;

	public BufferedImage tree1;
	public BufferedImage tree2;
	public BufferedImage tree3;
	public BufferedImage tree4;
	public BufferedImage tree5;
	public BufferedImage tree6;
	public BufferedImage tree7;
	public BufferedImage tree8;
	public BufferedImage tree9;

	public BufferedImage c1;
	public BufferedImage c2;
	public BufferedImage c3;
	public BufferedImage c4;

	public BufferedImage rules1;
	public BufferedImage rules2;
	public BufferedImage rules3;
	public BufferedImage start;

	public Renderer r;
	private int moveY;
	private int moveX;
	private Timer timer;

	private boolean started = false;

	private boolean gameOver;

	private long counter = 0;

	public FlappyBlock() {

		JFrame window = new JFrame("Flappy Block");
		timer = new Timer(20, this);

		r = new Renderer();

		block = new Rectangle(WINDOW_WIDTH / 2 - 100, WINDOW_HEIGHT / 3 - 100,
				50, 50);

		cloud1 = new Rectangle(WINDOW_WIDTH + 200, ((int) (Math.random()
				* (-300) - 200)), 436, 534);

		cloud2 = new Rectangle(cloud1.x + cloud1.width + 200,
				((int) (Math.random() * (-300) - 100)), 318, 386);

		cloud3 = new Rectangle(cloud2.x + cloud2.width + 200,
				((int) (Math.random() * (-300) - 200)), 376, 649);

		cloud4 = new Rectangle(cloud3.x + cloud3.width + 200,
				((int) (Math.random() * (-300) - 100)), 338, 462);

		t1 = new Rectangle(WINDOW_WIDTH + 300, WINDOW_HEIGHT - 240, 146, 240);

		t2 = new Rectangle(t1.x + t1.width + 300, WINDOW_HEIGHT - 236, 210, 236);
		t3 = new Rectangle((t2.x + t2.width + 300), WINDOW_HEIGHT - 242, 191,
				242);
		t4 = new Rectangle((t3.x + t3.width + 300), WINDOW_HEIGHT - 223, 214,
				223);
		t5 = new Rectangle((t4.x + t4.width + 300), WINDOW_HEIGHT - 216, 224,
				216);
		t6 = new Rectangle((t5.x + t5.width + 300), WINDOW_HEIGHT - 219, 153,
				219);
		t7 = new Rectangle((t6.x + t6.width + 300), WINDOW_HEIGHT - 240, 154,
				240);
		t8 = new Rectangle((t7.x + t7.width + 300), WINDOW_HEIGHT - 243, 169,
				243);
		t9 = new Rectangle((t8.x + t8.width + 300), WINDOW_HEIGHT - 213, 167,
				213);

		try {
			bird = ImageIO.read(ResLoader.load("Black_bird_64.png"));

			clouds = ImageIO.read(ResLoader.load("sky.jpg"));

			tree1 = ImageIO.read(ResLoader.load("tree1.png"));

			tree2 = ImageIO.read(ResLoader.load("tree2.png"));

			tree3 = ImageIO.read(ResLoader.load("tree3.png"));

			tree4 = ImageIO.read(ResLoader.load("tree4.png"));

			tree4 = ImageIO.read(ResLoader.load("tree4.png"));

			tree5 = ImageIO.read(ResLoader.load("tree5.png"));

			tree6 = ImageIO.read(ResLoader.load("tree6.png"));

			tree7 = ImageIO.read(ResLoader.load("tree7.png"));

			tree8 = ImageIO.read(ResLoader.load("tree8.png"));

			tree9 = ImageIO.read(ResLoader.load("tree9.png"));

			c1 = ImageIO.read(ResLoader.load("cloud1.png"));

			c2 = ImageIO.read(ResLoader.load("cloud2.png"));

			c3 = ImageIO.read(ResLoader.load("cloud3.png"));

			c4 = ImageIO.read(ResLoader.load("cloud4.png"));

			rules1 = ImageIO.read(ResLoader.load("rules.png"));

			rules2 = ImageIO.read(ResLoader.load("space.png"));

			rules3 = ImageIO.read(ResLoader.load("clouds_trees.png"));

			start = ImageIO.read(ResLoader.load("start.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		window.add(r);
		window.setResizable(false);
		window.addKeyListener(this);
		window.addMouseListener(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setVisible(true);

		timer.start();

	}

	public void repaint(Graphics g) {

		g.drawImage(clouds, 0, 0, null);

		g.drawImage(bird, block.x, block.y, null);

		g.drawImage(c1, cloud1.x, cloud1.y, null);
		g.drawImage(c2, cloud2.x, cloud2.y, null);
		g.drawImage(c3, cloud3.x, cloud3.y, null);
		g.drawImage(c4, cloud4.x, cloud4.y, null);

		g.drawImage(tree1, t1.x, t1.y, null);
		g.drawImage(tree2, t2.x, t2.y, null);
		g.drawImage(tree3, t3.x, t3.y, null);
		g.drawImage(tree4, t4.x, t4.y, null);
		g.drawImage(tree5, t5.x, t5.y, null);
		g.drawImage(tree6, t6.x, t6.y, null);
		g.drawImage(tree7, t7.x, t7.y, null);
		g.drawImage(tree8, t8.x, t8.y, null);
		g.drawImage(tree9, t9.x, t9.y, null);

		if (gameOver == true) {
			g.setColor(Color.RED);

			g.setFont(new Font("Calibri", Font.BOLD, 50));
			g.drawString("GAME OVER", WINDOW_WIDTH / 3 - 50, WINDOW_HEIGHT / 2);

		}
		if (started == false) {
			g.drawImage(rules1, WINDOW_WIDTH / 8 - 140, WINDOW_HEIGHT / 2, null);
			g.drawImage(rules2, WINDOW_WIDTH / 8 - 140,
					WINDOW_HEIGHT / 2 + 110, null);
			g.drawImage(rules3, WINDOW_WIDTH / 8 - 140,
					WINDOW_HEIGHT / 2 + 220, null);
			g.drawImage(start, WINDOW_WIDTH / 3 + 30, WINDOW_HEIGHT / 3, null);

		}

	}

	public void jump() {
		if (gameOver == false) {
			if (moveY > 0) {
				moveY = 0;
			}

			if (block.y - moveY <= 0) {
				moveY = 0;
			} else {
				moveY -= 20;
			}
		}
	}

	public static void main(String[] args) {
		flappyBlock = new FlappyBlock();

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump();

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {

			started = true;

		}

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		moveX = 4;

		if (started == true) {
			if (moveY < 20) {
				moveY += 2;
			}

			if (block.y + block.height < WINDOW_HEIGHT - 50) {
				block.y += moveY;

			} else {

				block.y = WINDOW_HEIGHT - 50 - block.height;
				gameOver = true;

			}
			if (cloud1.x + cloud1.width <= 0) {
				cloud1.x = cloud4.x + cloud4.width + 400;
			} else if (cloud2.x + cloud2.width <= 0) {
				cloud2.x = cloud1.x + cloud1.width + 400;
			} else if (cloud3.x + cloud3.width <= 0) {
				cloud3.x = cloud2.x + cloud2.width + 400;
			} else if (cloud4.x + cloud4.width <= 0) {
				cloud4.x = cloud3.x + cloud3.width + 400;
			} else {
				cloud1.x -= moveX;

				cloud2.x -= moveX;

				cloud3.x -= moveX;

				cloud4.x -= moveX;
			}
			if (t1.x + t1.width <= 0) {

				t1.x = t9.x + t9.width + 300;

			} else if (t2.x + t2.width <= 0) {

				t2.x = t1.x + t1.width + 300;

			} else if (t3.x + t3.width <= 0) {

				t3.x = t2.x + t2.width + 300;

			} else if (t4.x + t4.width <= 0) {

				t4.x = t3.x + t3.width + 300;

			} else if (t5.x + t5.width <= 0) {

				t5.x = t4.x + t4.width + 300;

			} else if (t6.x + t6.width <= 0) {

				t6.x = t5.x + t5.width + 300;

			} else if (t7.x + t7.width <= 0) {

				t7.x = t6.x + t6.width + 300;

			} else if (t8.x + t8.width <= 0) {

				t8.x = t7.x + t7.width + 300;

			} else if (t9.x + t9.width <= 0) {

				t9.x = t8.x + t8.width + 300;

			} else {
				t1.x -= moveX;
				t2.x -= moveX;
				t3.x -= moveX;
				t4.x -= moveX;
				t5.x -= moveX;
				t6.x -= moveX;
				t7.x -= moveX;
				t8.x -= moveX;
				t9.x -= moveX;
			}

			if (block.intersects(cloud1) || block.intersects(cloud2)
					|| block.intersects(cloud3) || block.intersects(cloud4)
					|| block.intersects(t1) || block.intersects(t2)
					|| block.intersects(t3) || block.intersects(t4)
					|| block.intersects(t5) || block.intersects(t6)
					|| block.intersects(t7) || block.intersects(t8)
					|| block.intersects(t9)) {
				gameOver = true;

			}

			if (block.intersects(cloud1)) {
				block.x = cloud1.x - block.width;
			} else if (block.intersects(cloud2)) {
				block.x = cloud2.x - block.width;
			} else if (block.intersects(cloud3)) {
				block.x = cloud3.x - block.width;
			} else if (block.intersects(cloud4)) {
				block.x = cloud4.x - block.width;
			} else if (block.intersects(t1)) {
				block.x = t1.x - block.width;
			} else if (block.intersects(t2)) {
				block.x = t2.x - block.width;
			} else if (block.intersects(t3)) {
				block.x = t4.x - block.width;
			} else if (block.intersects(t4)) {
				block.x = t4.x - block.width;
			} else if (block.intersects(t5)) {
				block.x = t5.x - block.width;
			} else if (block.intersects(t6)) {
				block.x = t6.x - block.width;
			} else if (block.intersects(t7)) {
				block.x = t7.x - block.width;
			} else if (block.intersects(t8)) {
				block.x = t8.x - block.width;
			} else if (block.intersects(t9)) {
				block.x = t9.x - block.width;
			}

		}
		r.repaint();

	}

}
