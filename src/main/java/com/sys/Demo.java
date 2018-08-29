package com.sys;

public class Demo {

	public static void main(String[] args) {
		Hello hello = param -> param + "World";
		System.out.println(hello.msg("Hello,"));
		System.out.println(testTryFinally());
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
