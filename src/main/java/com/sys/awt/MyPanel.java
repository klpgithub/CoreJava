package com.sys.awt;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyPanel extends JPanel implements ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JList list;
	JTextField tf;

	public MyPanel(String listItem[], JTextField tf) {
		//JTextField 没显示
		this.tf = tf;
		tf.setBounds(100, 100, 100, 100);
		tf.setVisible(true);
		list = new JList<>(listItem);
		list.setVisibleRowCount(5);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(this);
		JScrollPane jsp = new JScrollPane(list);
		jsp.setSize(100, 200);
		//设置滚动条一直可见
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(jsp);
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == list) {
			System.out.println(list.getSelectedValue());
			tf.setText(list.getSelectedValue() + "被选中\n");
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MyPanel panel = new MyPanel(new String[] {"aa","bb","cc","dd","ee","ff","hh","gg","rr","tt"}, new JTextField());
				JFrame frame = new JFrame("JFrame");
				frame.setSize(500,500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				frame.add(panel);
			}
		});
		
		
		
	}

}
