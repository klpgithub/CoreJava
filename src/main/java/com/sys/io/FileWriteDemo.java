package com.sys.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import org.junit.Test;

public class FileWriteDemo {

	@Test
	public void testOutputStream() throws IOException {
		FileOutputStream fos = new FileOutputStream("./testOutputStream.txt");
		fos.write("测试\n".getBytes(Charset.forName("utf-8")));
		fos.write("hahahaha\n".getBytes());
		fos.flush();
		fos.close();
	}

	@Test
	public void testOutputStream2() throws IOException {
		FileInputStream fis = new FileInputStream(new File("./testOutputStream.txt"));
		FileOutputStream fos = new FileOutputStream(new File("./testOutputStream2.txt"));
		int len = 0;
		// 一次写入一个字节
		while ((len = fis.read()) != -1) {
			fos.write(len);
		}
		fos.flush();
		fos.close();
		fis.close();
	}

	@Test
	public void testOutputStream3() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("./testOutputStream.txt");
		FileOutputStream fos = new FileOutputStream("./testOutputStream3.txt");
		int len = 0;
		// 每次写入一个字节数组
		byte[] bytes = new byte[1024];
		while ((len = fileInputStream.read(bytes)) != -1) {
			fos.write(bytes, 0, len);
		}
		fos.flush();
		fos.close();
		fileInputStream.close();
	}

	@Test
	public void testBufferedInputStream() throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./testOutputStream.txt"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./testOutputStream4.txt"));
		int len = 0;
		while ((len = bis.read()) != -1) {
			bos.write(len);
		}
		bos.flush();
		bos.close();
		bis.close();
	}

	@Test
	public void testBufferedInputStream2() throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("./testOutputStream.txt"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./testOutputStream5.txt"));
		int len = 0;
		byte[] bytes = new byte[1024];
		while ((len = bis.read(bytes)) != -1) {
			bos.write(bytes, 0, len);
		}
		bos.flush();
		bos.close();
		bis.close();
	}

	@Test
	public void testBufferReader() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("./testOutputStream.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("./testOutputStream6.txt"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			writer.write(line);
			writer.newLine();
		}
		writer.flush();
		writer.close();
		reader.close();
	}

	@Test
	public void testBufferReader2() throws IOException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("./testOutputStream.txt"), Charset.forName("UTF-8")));
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("./testOutputStream7.txt"), Charset.forName("GBK")));
		String line = null;
		while ((line = reader.readLine()) != null) {
			writer.write(line);
			writer.newLine();
		}
		writer.flush();
		writer.close();
		reader.close();
	}

}
