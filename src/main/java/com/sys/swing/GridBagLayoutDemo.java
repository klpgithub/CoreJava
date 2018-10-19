package com.sys.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridBagLayoutDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GridBagLayout");
		frame.setSize(frame.getMaximumSize());

		// 布局管理器
		GridBagLayout layout = new GridBagLayout();
		// 约束
		GridBagConstraints c = null;

		JPanel panel = new JPanel(layout);

		JButton b1 = new JButton("JButton1");
		JButton b2 = new JButton("JButton2");
		JButton b3 = new JButton("JButton3");
		JButton b4 = new JButton("JButton4");
		JButton b5 = new JButton("JButton5");
		JButton b6 = new JButton("JButton6");
		JButton b7 = new JButton("JButton7");
		JButton b8 = new JButton("JButton8");
		JButton b9 = new JButton("JButton9");
		JButton b10 = new JButton("JButton10");

		/* 添加 组件 和 约束 到 布局管理器 */
		// Button01
		c = new GridBagConstraints();
		// 内部使用的仅是 c 的副本
		layout.addLayoutComponent(b1, c);

		// Button02
		c = new GridBagConstraints();
		layout.addLayoutComponent(b2, c);

		// Button03
		c = new GridBagConstraints();
		layout.addLayoutComponent(b3, c);

		// Button04 显示区域占满当前行剩余空间（换行），组件填充显示区域 remainder 其余
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		layout.addLayoutComponent(b4, c);

		// Button05 显示区域独占一行（换行），组件填充显示区域
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		layout.addLayoutComponent(b5, c);

		// Button06 显示区域占到当前尾倒数第二个单元格（下一个组件后需要手动换行），组件填充显示区域
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.RELATIVE;
		c.fill = GridBagConstraints.BOTH;
		layout.addLayoutComponent(b6, c);

		// Button07 放置在当前行最后一个单元格（换行）
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		layout.addLayoutComponent(b7, c);

		// Button08 显示区域占两列，组件填充显示区域
		c = new GridBagConstraints();
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		layout.addLayoutComponent(b8, c);

		// Button09 显示区域占满当前行剩余空间（换行），组件填充显示区域
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		layout.addLayoutComponent(b9, c);

		// Button10 显示区域占满当前行剩余空间（换行），组件填充显示区域
		c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.BOTH;
		layout.addLayoutComponent(b10, c);

		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b10);

		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
