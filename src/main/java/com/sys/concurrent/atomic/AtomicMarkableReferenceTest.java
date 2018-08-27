package com.sys.concurrent.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * 用AtomicMarkableReferenct解决ABA问题(只需要知道数据是否被改变时使用)
 * Created by klp on 2018年8月27日上午10:11:54.
 */
public class AtomicMarkableReferenceTest {

	private static AtomicMarkableReference<Integer> atomicMarkableInteger = new AtomicMarkableReference<Integer>(100,
			false);

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				atomicMarkableInteger.compareAndSet(100, 222, false, true);
				atomicMarkableInteger.compareAndSet(222, 100, true, false);
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				boolean b = atomicMarkableInteger.isMarked();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				boolean c = atomicMarkableInteger.compareAndSet(100, 666, b, !b);
				System.out.println(c);
			}
		});
		t2.start();

		Thread.sleep(3000);
	}

}
