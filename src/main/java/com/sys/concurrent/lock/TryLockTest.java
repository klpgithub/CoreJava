package com.sys.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可以使用 tryLock()或者tryLock(long timeout, TimeUtil unit) 方法进行一次限时的锁等待。
 * 
 * 前者不带参数，这时线程尝试获取锁，如果获取到锁则继续执行，如果锁被其他线程持有，则立即返回 false ，也就是不会使当前线程等待，所以不会产生死锁。
 * 后者带有参数，表示在指定时长内获取到锁则继续执行，如果等待指定时长后还没有获取到锁则返回false。
 */
public class TryLockTest implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();

	public void run() {
		try {
			if (lock.tryLock(1, TimeUnit.SECONDS)) {
				Thread.sleep(2000);
			} else {
				System.err.println(Thread.currentThread().getName() + "获取锁失败");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			if (lock.isHeldByCurrentThread()) {
				System.out.println(Thread.currentThread().getName());
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		TryLockTest tryLockTest = new TryLockTest();
		Thread t1 = new Thread(tryLockTest);
		t1.setName("线程1");
		Thread t2 = new Thread(tryLockTest);
		t2.setName("线程2");
		t1.start();
//		Thread.sleep(500);// 保证线程1先执行
		t2.start();

	}

}
