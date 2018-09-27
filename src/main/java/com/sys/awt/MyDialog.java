package com.sys.awt;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyDialog {
	public static void main(String[] args) {
		JFrame frame = new JFrame("测试");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton("显示自定义对话框");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showCustomerDialog(frame, frame);
			}
		});

		JPanel panel = new JPanel();
		panel.add(button);

		frame.setContentPane(panel);
		frame.setVisible(true);
	}

	private static void showCustomerDialog(Frame owner, Component parent) {
		// 创建一个模态对话框
		JDialog dialog = new JDialog(owner, "提示", true);
		// 设置对话框的宽高
		dialog.setSize(200, 200);
		// 设置对话框不可改变大小
		dialog.setResizable(false);
		// 设置对话框相对位置
		dialog.setLocationRelativeTo(parent);

		// 创建一个按钮用于关闭对话框
		JButton okBtn = new JButton("确定");
		okBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 关闭对话框
				dialog.dispose();
			}
		});

		JButton button = new JButton("取消");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});
		JPanel panel = new JPanel();
		panel.add(button);
		panel.add(okBtn);
		// 设置对话框的内容面板
		dialog.setContentPane(panel);
		// 显示对话框
		dialog.setVisible(true);
	}

}
