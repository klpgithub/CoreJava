package com.sys.awt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class GraphicsDemo {

	@Test
	public void testGraphics2D() throws FileNotFoundException, IOException {
		// 获得画板
		BufferedImage bi = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
		// 获取画笔
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		// 设置背景颜色
		g2.setColor(Color.RED);
		g2.fillRect(0, 0, 150, 150);
		g2.drawRect(0, 0, 150 - 1, 150 - 1);
		g2.setFont(new Font("宋体", Font.BOLD, 15));
		g2.setColor(Color.blue);
		g2.drawString("HelloWorld", 30, 60);
		ImageIO.write(bi, "JPG", new FileOutputStream("D:/Graphics.jpg"));
	}

	@Test
	public void test() throws FileNotFoundException, IOException {
		// 获得画板
		BufferedImage bi = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
		// 获取画笔
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, 150, 150);
		g2.setColor(Color.red);
		Rectangle2D rect = new Rectangle2D.Double(10, 30, 100, 100);
		g2.draw(rect);
		ImageIO.write(bi, "JPG", new FileOutputStream("D:/Graphics.jpg"));
	}

}
