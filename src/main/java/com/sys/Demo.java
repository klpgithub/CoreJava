package com.sys;

public class Demo {

	public static void main(String[] args) {
//		Hello hello = param -> param + "World";
//		System.out.println(hello.msg("Hello,"));
//		System.out.println(testTryFinally());

		int i = 0x3abc;
		long y = 0xabcl;
		int[][] x = { { 1, 2, 3 }, { 4, 5 }, { 6, 7 }, {} };
		String s = "ABCDEFGABC";
		System.out.println(s.indexOf('A', 7));
		System.out.println(x.length);
		System.out.println(i);

	}

	public static int testTryFinally() {
		try {
			Thread.sleep(100);
			return 1;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return 0;
		} finally {
			return 2;
		}
	}

}
