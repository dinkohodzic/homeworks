package ba.bitcamp.homeworkWeekend11.task2;

import java.util.Random;

public class Task2 {

	public static void main(String[] args) {
		// Initializing threads
		Thread t1 = new Thread(new firstThread());
		Thread t2 = new Thread(new secondThread());
		Thread t3 = new Thread(new thirdThread());
		
		//starting the first thread
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//starting the second thread
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//starting the third thread
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
			
		
		

	}
	/**
	 * 
	 * @author Dinko Hodzic
	 * Inner class for the first Thread
	 *
	 */
	static class firstThread implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(1 + i);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	/**
	 * 
	 * @author Dinko Hodzic
	 * Inner class for the second Thread
	 *
	 */
	static class secondThread implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 4; i++) {
				System.out.println("BitCampp");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	/**
	 * 
	 * @author Dinko Hodzic
	 * Inner class for the third Thread
	 *
	 */
	static class thirdThread implements Runnable {
		Random rand = new Random();
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println(rand.nextInt((5 - 1) + 1) + 1);
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

}
