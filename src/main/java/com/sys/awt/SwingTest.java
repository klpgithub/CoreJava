package com.sys.awt;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SwingTest {

	/**
	 * 创建并显示GUI。出于线程安全的考虑，
	 * 这个方法在事件调用线程中调用。
	 */
	private static void createAndShowGUI() {
		// 确保一个漂亮的外观风格
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Hello world");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 添加 "Hello World" 标签
		JLabel label = new JLabel("Hello world");
		frame.getContentPane().add(label);
		// 显示窗口
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				createAndShowGUI();
			}
		});

	}
}
