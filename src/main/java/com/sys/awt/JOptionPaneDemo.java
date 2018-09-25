package com.sys.awt;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.junit.Test;

public class JOptionPaneDemo {

	public JFrame getDefaultFrame() {
		JFrame frame = new JFrame("测试");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return frame;
	}

	@Test
	public void testConfirm() {
//		JFrame frame = getDefaultFrame();
		JOptionPane.showConfirmDialog(null, "123");
		JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
		//java.lang.RuntimeException: JOptionPane: parentComponent does not have a valid parent ????
		JOptionPane.showInternalMessageDialog(null, "information");
//		JOptionPane.showConfirmDialog(null, "choose one", "choose one", JOptionPane.YES_NO_OPTION);
//		JOptionPane.showInternalConfirmDialog(frame, "please choose one", "information",
//				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

	}

}
