package com.sys;

public class Demo {

	public static void main(String[] args) {
		Hello hello = param -> param + "World";
		System.out.println(hello.msg("Hello,"));
	}

}
