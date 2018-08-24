package com.sys.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 对于synchronized块来说，要么获取到锁执行，要么持续等待。而重入锁的中断响应功能就合理地避免了这样的情况。
 * 比如，一个正在等待获取锁的线程被“告知”无须继续等待下去，就可以停止工作了。直接上代码，来演示使用重入锁如何解决死锁：
 * 
 * t1、t2线程开始运行时，会分别持有lock1和lock2而请求lock2和lock1，这样就发生了死锁。
 * 但是，在③处给t2线程状态标记为中断后，持有重入锁lock2的线程t2会响应中断，并不再继续等待lock1，
 * 同时释放了其原本持有的lock2，这样t1获取到了lock2，正常执行完成。t2也会退出，但只是释放了资源并没有完成工作。 Created by klp
 * on 2018年8月23日下午2:34:30.
 */
public class KillDeadLock implements Runnable {

	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();

	int lock;

	public KillDeadLock(int lock) {
		this.lock = lock;
	}

	public void run() {
		try {
			if (lock == 1) {
				lock1.lockInterruptibly();// 以可以响应中断的方式加锁
				Thread.sleep(1000);
				lock2.lockInterruptibly();
			} else {
				lock2.lockInterruptibly();// 以可以响应中断的方式加锁
				Thread.sleep(1000);
				lock1.lockInterruptibly();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if (lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
			System.out.println(Thread.currentThread().getId() + "--退出!");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		KillDeadLock killDeadLock1 = new KillDeadLock(1);
		KillDeadLock killDeadLock2 = new KillDeadLock(2);
		Thread t1 = new Thread(killDeadLock1);
		System.out.println("t1-->" + t1.getId());
		Thread t2 = new Thread(killDeadLock2);
		System.out.println("t2-->" + t2.getId());
		t1.start();
		t2.start();
		Thread.sleep(2000);
		t2.interrupt();// 3
	}
}
