package com.sys.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

public class AtomicIntegerTest {

	public static void main(String[] args) {
		AtomicInteger integer = new AtomicInteger(100);
		int a = integer.incrementAndGet();
		System.out.println(a);
		int b = integer.decrementAndGet();
		System.out.println(b);
		int c = integer.addAndGet(200);
		System.out.println(c);
		int d = integer.accumulateAndGet(1, new IntBinaryOperator() {
			public int applyAsInt(int left, int right) {
				return left * right;
			}
		});
		System.out.println(d);
		int e = integer.getAndAccumulate(1, new IntBinaryOperator() {
			public int applyAsInt(int left, int right) {
				return left * right;
			}
		});
		int f = integer.getAndSet(100);
		int g = integer.updateAndGet(new IntUnaryOperator() {
			public int applyAsInt(int operand) {
				return operand;
			}
		});
		boolean h = integer.compareAndSet(100, 1);
		System.out.println(h);
		integer.lazySet(200);
		integer.weakCompareAndSet(200, 30000000);// jdk8以及之前实现与compareAndSet方法一致
		System.out.println(integer);
	}

}
