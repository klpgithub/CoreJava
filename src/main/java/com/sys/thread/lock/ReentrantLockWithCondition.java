package com.sys.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithCondition implements Runnable {

	private static ReentrantLock lock = new ReentrantLock(true);
	public static Condition condition = lock.newCondition();

	public void run() {
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + "--线程开始等待");
			condition.await();
			System.out.println(Thread.currentThread().getName() + "--线程继续执行");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockWithCondition test = new ReentrantLockWithCondition();
		Thread t1 = new Thread(test, "线程ABC");
		t1.start();
		Thread.sleep(1000);
		System.out.println("过了1秒后....");
		lock.lock();
		condition.signal();// 调用该方法前需要获取到创建该对象的锁否则会产生 java.lang.IllegalMonitorStateException异常
		lock.unlock();
	}

}
