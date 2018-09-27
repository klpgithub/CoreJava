package com.sys.awt;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MyWindow extends JFrame implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea text;
	JCheckBox[] box;
	String[] boxName = { "张三", "李四", "王五", "测试", "张武", "小明" };

	public MyWindow(String string) {
		super(string);
		Image image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Administrator\\Desktop\\qq.png");
		setIconImage(image);
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(1, 2));
		setLocation(100, 100);
		JPanel panel = new JPanel();
		int len = boxName.length;
		panel.setLayout(new GridLayout(len, 1));
		box = new JCheckBox[len];
		for (int i = 0; i < len; i++) {
			box[i] = new JCheckBox(boxName[i]);
			box[i].addItemListener(this);
			panel.add(box[i]);
		}
		text = new JTextArea(4, 10);
		container.add(panel);
		container.add(text);
		setVisible(true);
		pack();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		StringBuilder ss = new StringBuilder();
		for (int i = 0; i < box.length; i++) {
			if (box[i].isSelected()) {
				ss.append(boxName[i] + "被选中\n");
			} else {
				ss.append(boxName[i] + "没有被选中\n");
			}
		}
		text.setText(ss.toString());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MyWindow("2018年四月考题");
			}
		});

	}

}
