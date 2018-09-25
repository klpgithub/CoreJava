package com.sys.base;

public class Test {

	public static void main(String[] args) {
		Test2 test2 = new Test2();
		test2.m1();
		test2.m2();
		test2.m3();
	}

}

class Test1 {
	public void m1() {
		System.out.println("call Test1's m1");
	}

	public void m2() {
		System.out.println("call Test1's m2");
	}
}

class Test2 extends Test1 {
	public void m1() {
		System.out.println("call Test2's m1");
	}

	public void m3() {
		super.m1();
		System.out.println("call Test2's m3");
	}
}
