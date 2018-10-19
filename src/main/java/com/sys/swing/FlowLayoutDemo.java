package com.sys.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class FlowLayoutDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("测试窗口");
		frame.setSize(200, 200);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		// 创建内容面板，指定使用 流式布局
		JPanel panel = new JPanel(new FlowLayout());

		JButton b1 = new JButton("按钮1");
		JButton b2 = new JButton("按钮2");
		JButton b3 = new JButton("按钮3");
		JButton b4 = new JButton("按钮4");
		JButton b5 = new JButton("按钮5");
		JButton b6 = new JButton("按钮6");

		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);

		frame.setContentPane(panel);

		frame.setVisible(true);// PS: 最后再设置为可显示(绘制), 所有添加的组件才会显示
	}

}
