package com.sys.awt;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * java图像界面开发简单实例
 *	Graphics2D、Rectangle2D、Ellipse2D、Line2D的简单应用,原理为创建相应的图形对象，
 *	并设置图形的大小及相关设置，通过Graphics2D对象的draw方法将图形对象保存与JPanel面板中
 * @author Administrator
 *
 */
public class Example5Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Example5Frame() {
		setTitle("绘制图形");// 设置窗体的标题
		setSize(400, 400);// 设置窗体的大小
		// 将定义的DrawPanel对象添加到窗体
		DrawPanel panel = new DrawPanel();
		add(panel);
	}

	public static void main(String[] args) {
		Example5Frame frame = new Example5Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/**
 * 定义一个JPanel对象用于保存绘制的图形的设置
 */
class DrawPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;// 将Graphics对象转换为Graphics2D对象
		// 绘制矩形
		double leftX = 100;// 定义开始绘制的坐标
		double topY = 100;
		double width = 200;// 定义绘制宽度
		double height = 150;// 定义绘制高度
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);// 创建矩形对象
		g2.draw(rect);// 将矩形对象绘制于Panel面板上
		// 绘制椭圆
		Ellipse2D ellipse = new Ellipse2D.Double();// 创建椭圆对象
		ellipse.setFrame(rect);// 设置椭圆的绘制框架为上面的矩形（即与矩形内接）
		g2.draw(ellipse);// 将椭圆对象绘制于Panel面板上
		// 绘制线条
		Line2D line = new Line2D.Double(leftX, topY, leftX + width, topY + height);// 创建线条对象（4个参数表示两个端点坐标）
		g2.draw(line);// 将线条对象绘制于Panel面板上
		// 绘制圆
		double centerX = rect.getCenterX();// 定义圆心坐标（以矩形的中心为圆心）
		double centerY = rect.getCenterY();
		double radius = 150;// 定义圆的半径
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);// 设置圆形的绘制框架（4个参数表示中心点坐标和角点坐标）
		g2.draw(circle);// 将圆形对象绘制于Panel面板上
	}
}
