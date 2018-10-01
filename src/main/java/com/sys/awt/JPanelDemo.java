package com.sys.awt;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JPanelDemo extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelDemo() {
		setBackground(Color.blue);
		setLayout(new FlowLayout());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(500, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JPanelDemo panel = new JPanelDemo();
				frame.getContentPane().add(panel);
				frame.setVisible(true);
			}
		});

	}

}
