package com.sys.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.function.IntBinaryOperator;

public class AtomicIntegerArrayTest {

	private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);

	public static void main(String[] args) {
		atomicIntegerArray.set(0, 1);
		atomicIntegerArray.accumulateAndGet(1, 2, new IntBinaryOperator() {
			public int applyAsInt(int left, int right) {
				return right;
			}
		});
		atomicIntegerArray.addAndGet(2, 3);
		atomicIntegerArray.compareAndSet(3, 0, 4);
		atomicIntegerArray.decrementAndGet(4);
		System.out.println(atomicIntegerArray.get(4));
		atomicIntegerArray.incrementAndGet(4);
		System.out.println(atomicIntegerArray);
	}
}
