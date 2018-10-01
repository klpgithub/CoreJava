package com.sys.awt;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class JTextAreaDemo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextAreaDemo() {
		super("JTextAreaDemo");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);

		JTextArea text = new JTextArea("aaaaaaaaaaaaaaaaaaaaaadaadadadadadada");
		text.setBounds(100, 100, 100, 200);
		// 设置自动换行
		text.setLineWrap(true);
		add(text);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new JTextAreaDemo();
			}
		});

	}

}
