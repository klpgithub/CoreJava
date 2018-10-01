package com.sys.awt;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CardLayoutDemo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton nextButton;
	JButton preButton;
	JButton firstButton;
	JButton lastButton;

	Panel cardPanel = new Panel();
	Panel controlPanel = new Panel();

	CardLayout card = new CardLayout();

	public CardLayoutDemo() {
		super("卡片布局管理器");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		// 设置cardPanel面板对象为卡片布局
		cardPanel.setLayout(card);

		for (int i = 0; i < 10; i++) {
			cardPanel.add(new JButton("按钮" + i));
		}
		nextButton = new JButton("下一张卡片");
		preButton = new JButton("上一张卡片");
		firstButton = new JButton("第一张");
		lastButton = new JButton("最后一张");
		nextButton.addActionListener(this);
		preButton.addActionListener(this);
		firstButton.addActionListener(this);
		lastButton.addActionListener(this);

		controlPanel.add(firstButton);
		controlPanel.add(preButton);
		controlPanel.add(nextButton);
		controlPanel.add(lastButton);
		// 定义容器对象为当前窗体容器对象
		Container container = getContentPane();
		// 将cardPanel面板放置在窗口布局的中间,窗口默认为边界布局
		container.add(cardPanel, BorderLayout.CENTER);
		// 将controlPanel面板放置在窗口布局的南边
		container.add(controlPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 如果点击nextButton
		if (e.getSource() == nextButton) {
			// 切换cardPanel面板中当前组件之后的一个组件
			// 若当前组件为最后添加的组件，则显示第一个组件，即卡片组件显示是循环的。
			card.next(cardPanel);
		}
		if (e.getSource() == preButton) {
			// 切换cardPanel面板中当前组件之前的一个组件
			// 若当前组件为第一个添加的组件，则显示最后一个组件，即卡片组件显示是循环的。
			card.previous(cardPanel);
		}
		if (e.getSource() == firstButton) {
			card.first(cardPanel);
		}
		if (e.getSource() == lastButton) {
			card.last(cardPanel);
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				CardLayoutDemo cardLayoutDemo = new CardLayoutDemo();
			}
		});

	}

}
