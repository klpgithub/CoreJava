package com.sys.awt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class BorderLayoutDemo extends JFrame {

	private JPanel panel = new JPanel();

	public BorderLayoutDemo() {
		setLayout(new BorderLayout(5, 5));
		setFont(new Font("Helvetica", Font.BOLD, 15));
		getContentPane().add(BorderLayout.NORTH, new JButton("North"));
		getContentPane().add(BorderLayout.SOUTH, new JButton("South"));
		getContentPane().add(BorderLayout.EAST, new JButton("East"));
		getContentPane().add(BorderLayout.CENTER, new JButton("Center"));
		getContentPane().add(BorderLayout.WEST, new JButton("West"));
		// 设置面板为流式布局居中显示，组件横、纵间距为5个像素
		panel.setLayout(new FlowLayout());
		// 添加十个按钮到CENTER
		for (int i = 1; i < 10; i++) {
			panel.add(new JButton(String.valueOf(i)));
		}
		getContentPane().add(BorderLayout.CENTER, panel);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				BorderLayoutDemo layout = new BorderLayoutDemo();
				layout.setTitle("边界布局");
				// 设置窗口自适应大小
				layout.pack();
				layout.setVisible(true);
				layout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// 设置窗口居中显示
				layout.setLocationRelativeTo(null);
			}
		});
	}

}
