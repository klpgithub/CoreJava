package com.sys.awt;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MyPanel38 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Font font = new Font("楷体", Font.BOLD, 18);

	public MyPanel38(JTextField fad[], String[] fName, JTextArea anserArea, JButton bt) {
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		for (int i = 0; i < fad.length; i++) {
			JLabel label = new JLabel(fName[i], JLabel.RIGHT);
			label.setFont(font);
			panel.add(label);
			fad[i] = new JTextField(3);
			fad[i].setFont(font);
			panel.add(fad[i]);
		}
		add(panel, BorderLayout.WEST);
		JScrollPane scrollPane = new JScrollPane(anserArea);
		add(scrollPane, BorderLayout.CENTER);
		add(bt, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setSize(505, 500);
				JButton bt = new JButton("求解");
				JTextArea anserArea = new JTextArea("");
				anserArea.setLineWrap(true);
				anserArea.setEditable(false);
				anserArea.append("A\nS\nD\nF\nG\nH\nH");
				String[] fName = new String[] { "A", "B", "C", "D", "E", "F", "G", "H" };
				JTextField[] fad = new JTextField[8];
				fad[0] = new JTextField("1");
				fad[1] = new JTextField("2");
				fad[2] = new JTextField("3");
				fad[3] = new JTextField("4");
				fad[4] = new JTextField("5");
				fad[5] = new JTextField("6");
				fad[6] = new JTextField("7");
				fad[7] = new JTextField("8");
				MyPanel38 panel = new MyPanel38(fad, fName, anserArea, bt);
				frame.getContentPane().add(panel);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}
