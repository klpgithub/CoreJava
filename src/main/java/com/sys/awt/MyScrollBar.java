package com.sys.awt;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class MyScrollBar implements AdjustmentListener {

	JScrollBar js;
	JLabel label;
	int size = 20;

	public MyScrollBar() {
		JFrame frame = new JFrame("我的滚动条");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 710, 800);
		Container pane = frame.getContentPane();
		js = new JScrollBar(JScrollBar.VERTICAL, 10, 10, 10, 100);
		js.setSize(30, 700);
		js.addAdjustmentListener(this);
		pane.add(js);
		label = new JLabel("我的标签文字", SwingConstants.CENTER);
		pane.add(label);
		frame.setVisible(true);
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		size = e.getValue();
		Font font = new Font(label.getFont().getName(), label.getFont().getStyle(), size);
		label.setFont(font);
		label.setText(label.getText().substring(0, 6) + size);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MyScrollBar();
			}
		});

	}

}
