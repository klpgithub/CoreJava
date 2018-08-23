package com.sys.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class FairLockTest implements Runnable {

	public static ReentrantLock lock = new ReentrantLock(true);// true为公平锁,false为非公平锁

	public void run() {
		while (true) {
			lock.lock();
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "  获取到锁");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		FairLockTest fairLockTest = new FairLockTest();
		Thread t1 = new Thread(fairLockTest, "线程1");
		Thread t2 = new Thread(fairLockTest, "线程2");
		t1.start();
		t2.start();
	}
}
