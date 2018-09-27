package com.sys.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JOptionPaneDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * 信息消息对话框
		 */
		JButton b1 = new JButton("showMessageDialog(信息消息)");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Hello Information Message", "消息标题",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		/**
		 * 警告消息对话框
		 */
		JButton b2 = new JButton("showMessageDialog(警告消息)");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Hello Information Message", "消息标题", JOptionPane.WARNING_MESSAGE);
			}
		});

		/* 3. 确认对话框 */
		JButton b3 = new JButton("showConfirmDialog");
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* 返回用户点击的选项, 值为下面三者之一: 是: JOptionPane.YES_OPTION 否: JOptionPane.NO_OPTION 取消:
				 * JOptionPane.CANCEL_OPTION 关闭: JOptionPane.CLOSED_OPTION */
				int result = JOptionPane.showConfirmDialog(frame, "确认删除？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
				System.out.println("选择结果: " + result);
			}
		});

		/* 4. 输入对话框（文本框输入） */
		JButton b4 = new JButton("showInputDialog（文本框输入）");
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 显示输入对话框, 返回输入的内容
				String inputContent = JOptionPane.showInputDialog(frame, "输入你的名字:", "默认内容");
				System.out.println("输入的内容: " + inputContent);
			}
		});

		/* 5. 输入对话框（下拉框选择） */
		JButton b5 = new JButton("showInputDialog（下拉框选择）");
		b5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] selectionValues = new Object[] { "香蕉", "雪梨", "苹果" };

				// 显示输入对话框, 返回选择的内容, 点击取消或关闭, 则返回null
				Object inputContent = JOptionPane.showInputDialog(frame, "选择一项: ", "标题", JOptionPane.PLAIN_MESSAGE,
						null, selectionValues, selectionValues[0]);
				System.out.println("输入的内容: " + inputContent);
			}
		});

		/* 6. 选项对话框 */
		JButton b6 = new JButton("showOptionDialog");
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 选项按钮
				Object[] options = new Object[] { "香蕉", "雪梨", "苹果" };

				// 显示选项对话框, 返回选择的选项索引, 点击关闭按钮返回-1
				int optionSelected = JOptionPane.showOptionDialog(frame, "请点击一个按钮选择一项", "对话框标题",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, options, // 如果传null, 则按钮为
																									// optionType
																									// 类型所表示的按钮（也就是确认对话框）
						options[0]);

				if (optionSelected >= 0) {
					System.out.println("点击的按钮: " + options[optionSelected]);
				}
			}
		});

		Box box = Box.createVerticalBox();
		box.add(b1);
		box.add(b2);
		box.add(b3);
		box.add(b4);
		box.add(b5);
		box.add(b6);

		JPanel panel = new JPanel();
		panel.add(box);

		frame.setContentPane(panel);

		frame.setVisible(true);

	}

}
