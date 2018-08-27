package com.sys.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * jdk官方例子,没有运行成功,可能理解有问题
 * Created by klp on 2018年8月27日上午9:38:58.
 */
public class ConditionTest {

	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	final Object[] items = new Object[100];

	int putptr = 0, takeptr = 0, count = 0;

	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length) {
				notFull.await();
			}
			items[putptr] = x;
			if (++putptr == items.length) {
				putptr = 0;
			}
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0) {
				notEmpty.await();
			}
			Object x = items[takeptr];
			if (++takeptr == items.length) {
				takeptr = 0;
			}
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {

		final ConditionTest test = new ConditionTest();
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					test.put(new String());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {

			public void run() {
				try {
					test.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t2.start();
	}

}
