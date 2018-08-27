package com.sys.concurrent.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {

	private static AtomicInteger atomicInteger = new AtomicInteger(100);

	private static AtomicStampedReference<Integer> atomicStampedInteger = new AtomicStampedReference<Integer>(100, 0);

	public static void main(String[] args) throws InterruptedException {

		Thread intt1 = new Thread(new Runnable() {

			public void run() {
				atomicInteger.compareAndSet(100, 101);
				atomicInteger.compareAndSet(101, 100);
			}
		});
		Thread intt2 = new Thread(new Runnable() {

			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				boolean c = atomicInteger.compareAndSet(100, 101);
				System.out.println(c);// true
			}
		});
		intt1.start();
		intt1.join();
		intt2.start();
		intt2.join();

		Thread refT1 = new Thread(new Runnable() {

			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				atomicStampedInteger.compareAndSet(100, 101, atomicStampedInteger.getStamp(),
						atomicStampedInteger.getStamp() + 1);
				atomicStampedInteger.compareAndSet(101, 100, atomicStampedInteger.getStamp(),
						atomicStampedInteger.getStamp() + 1);

			}
		});
		Thread refT2 = new Thread(new Runnable() {

			public void run() {
				int stamp = atomicStampedInteger.getStamp();
				System.out.println(stamp);// 0
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				boolean d = atomicStampedInteger.compareAndSet(100, 101, stamp, stamp + 1);// false
				System.out.println(d);

			}
		});
		refT1.start();
		refT2.start();
	}
}
