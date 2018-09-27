package com.sys.awt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Swing实现的简单登录验证
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class MySwing extends JFrame {

	private JLabel userlabel;
	private JTextField userTextField;
	private JLabel pwdLabel;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton clearButton;

	public MySwing() {
		super("Hello world");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		getContentPane().setLayout(null);
		setVisible(true);
		
		add(getUserJlabel("用户名:"));
		add(getTextField());
		add(getPWDJLabel("密码:"));
		add(getJPasswordField());
		add(getLoginJButton("登录"));
		add(getClearButton("清空"));
	}

	private JLabel getUserJlabel(String name) {
		if (null == userlabel) {
			userlabel = new JLabel();
			userlabel.setBounds(50, 100, 80, 30);
			userlabel.setText(name);
		}
		return userlabel;
	}

	private JLabel getPWDJLabel(String name) {
		if (pwdLabel == null) {
			pwdLabel = new JLabel(name);
			pwdLabel.setBounds(50, 150, 80, 20);
		}
		return pwdLabel;
	}

	private JTextField getTextField() {
		if (userTextField == null) {
			userTextField = new JTextField();
			userTextField.setBounds(110, 100, 180, 20);
		}
		return userTextField;
	}

	private JPasswordField getJPasswordField() {
		if (null == passwordField) {
			passwordField = new JPasswordField();
			passwordField.setBounds(110, 150, 180, 20);
		}
		return passwordField;
	}

	private JButton getLoginJButton(String name) {
		if (loginButton == null) {
			loginButton = new JButton(name);
			loginButton.setBounds(110, 180, 60, 30);
		}
		loginButton.setBackground(Color.GREEN);
		loginButton.setOpaque(true);
		// 设置凹起来的按钮
		loginButton.setBorder(BorderFactory.createLoweredBevelBorder());
		// 点击事件
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("点击了登录按钮");
				String user = userTextField.getText();
				String pwd = new String(passwordField.getPassword());
				if ("张三".equals(user) && "123456".equals(pwd)) {
					System.out.println("登录成功,user:" + user + ";pwd:" + pwd);
				} else {
					System.out.println("登录失败,user:" + user + ";pwd:" + pwd);
				}
			}
		});
		// 鼠标事件
		loginButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		// 设置快捷键 ALT+A
		loginButton.setMnemonic(KeyEvent.VK_A);
		return loginButton;
	}

	private JButton getClearButton(String name) {
		if (clearButton == null) {
			clearButton = new JButton(name);
			clearButton.setBounds(200, 180, 60, 30);
		}
		clearButton.setBackground(Color.PINK);
		clearButton.setOpaque(true);
		clearButton.setBorder(BorderFactory.createEtchedBorder());
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userTextField.setText("");
				passwordField.setText("");
			}
		});
		return clearButton;
	}

	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				new MySwing();
			}
		});
	}

}
