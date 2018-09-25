package com.sys.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class BufferReaderDemo {

	/**
	 * 从控制台读取内容按回车输出
	 * @throws IOException
	 */
	@Test
	public void testBufferReader() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		String string;
		while ((string = reader.readLine()) != null) {
			System.out.println(string);
		}
		reader.close();
	}

}
