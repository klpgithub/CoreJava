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

		// 二维数组定义
		int a[][];
		int[][] b;
		int c[][] = new int[4][];
		int d[][] = new int[3][4];

		System.out.println(fact(5));
		System.out.println(1/2);
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

	// 阶乘1
	static long fact(int n) {
		int i;
		long f = 1;
		for (i = 1; i <= n; i++) {
			f = f * i;
		}
		return f;
	}

	// 阶乘2
	static long fact2(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * fact2(n - 1);
		}
	}

}
