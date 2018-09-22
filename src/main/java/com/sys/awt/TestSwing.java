package com.sys.awt;

import java.awt.Component;
import java.awt.Container;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestSwing {

	private static JFrame frame;
	private static JLabel label;

	private static void initFrame() {
		frame = new JFrame("Hello Swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);

		label = new JLabel("A Label");
		frame.add(label);
	}

	public static void main(String[] args) throws InterruptedException {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				initFrame();
			}
		});
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				label.setText("Hi,this is a different !!!");
			}
		});
	}

}
