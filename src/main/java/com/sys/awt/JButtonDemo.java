package com.sys.awt;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JButtonDemo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButtonDemo() {
		super("JButtonDemo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(600, 600);
		setVisible(true);

		add(getButton());

	}

	public JButton getButton() {
		JButton button = new JButton("按钮");
		//添加鼠标移动拖动事件
		button.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				System.out.println("mouseMoved");
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println("mouseDragged");
			}
		});
		button.setBounds(100, 100, 50, 30);
		return button;
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JButtonDemo();
			}
			
		});
		
		
	}
	
}
