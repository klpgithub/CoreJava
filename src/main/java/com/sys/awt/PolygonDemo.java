package com.sys.awt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PolygonDemo extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField text;
	int width, height;
	Polygon polygon = new Polygon();

	public PolygonDemo() {
		setLayout(new BorderLayout());
		text = new JTextField(10);
		add(text, BorderLayout.NORTH);
		text.addActionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, width, height);
		g.setColor(Color.RED);
		g.drawPolygon(polygon);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == text) {
			System.out.println(111);
			int r = Integer.parseInt(text.getText());
			width = this.getWidth();
			height = this.getHeight();
			polygon = new Polygon();
//			polygon.addPoint(width / 2 - r, height / 2 - r);
//			polygon.addPoint(width / 2 + r, height / 2 - r);
//			polygon.addPoint(width / 2 + r, height / 2 + r);
//			polygon.addPoint(width / 2 - r, height / 2 + r);
			polygon.addPoint(50, 50);
			polygon.addPoint(100, 50);
			polygon.addPoint(100, 100);
			polygon.addPoint(50, 100);
			repaint();
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				PolygonDemo panel = new PolygonDemo();
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(500, 500);
				frame.getContentPane().add(panel);
				frame.setLocation(100, 100);
				frame.setVisible(true);
			}
		});
		
	}

}
