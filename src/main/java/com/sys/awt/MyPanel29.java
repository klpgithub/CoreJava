package com.sys.awt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MyPanel29 extends JPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int index = 0;

	Color[] bgColors = { Color.red, Color.yellow, Color.blue };

	public MyPanel29() {
		addMouseListener(this);
		index = 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		index = (index + 1) % bgColors.length;
		setBackground(bgColors[index]);
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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame("JFrame");
				frame.setSize(500, 500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout(5, 5));
				frame.setVisible(true);
				MyPanel29 panel = new MyPanel29();
				panel.setLayout(new FlowLayout());
				frame.add(panel, BorderLayout.CENTER);
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				
			}
		});

	}

}
