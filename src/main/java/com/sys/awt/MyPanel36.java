package com.sys.awt;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPanel36 extends JPanel implements Runnable {

	Color[] cols = { Color.yellow, Color.BLUE, Color.red, Color.GRAY, Color.GREEN, Color.BLACK, Color.LIGHT_GRAY,
			Color.CYAN };
	int[] posX = { 40, 50, 60, 70, 80, 100, 120, 140 };
	int index = 0;

	public MyPanel36() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 500);
		frame.setContentPane(this);
//		setSize(300, 200);
		new Thread(this).start();
		frame.setVisible(true);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			index = (index + 1) % posX.length;
			repaint();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, 300, 200);
		System.out.println(index);
		g.setColor(cols[index]);
		g.fillOval(posX[index], 100 - posX[index] / 2, posX[index], posX[index] + 20);
	}

	public static void main(String[] args) {
		new MyPanel36();

	}

}
