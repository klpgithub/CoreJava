package com.sys.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock
 * 读锁共享,写锁独占,没有读锁的情况下才能获取到写锁
 *  Created by klp on 2018年8月24日上午10:42:41.
 */
public class ReentrantReadWriteLockTest {

	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public void get() {
		readWriteLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "--获取读锁了");
			readWriteLock.writeLock().lock();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readWriteLock.writeLock().unlock();
			readWriteLock.readLock().unlock();
		}
	}

	public void set() {
		readWriteLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "--获取写锁了");
			readWriteLock.readLock().lock();
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			readWriteLock.readLock().unlock();
			readWriteLock.writeLock().unlock();
		}
	}

	public static void main(String[] args) {
		final ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();
//		for (int i = 0; i < 1000; i++) {
//			new Thread(new Runnable() {
//				public void run() {
//					test.get();
//				}
//			}, "线程--" + i).start();
//		}
//
//		for (int i = 0; i < 3; i++) {
//			new Thread(new Runnable() {
//				public void run() {
//					test.set();
//				}
//			}, "写线程--" + i).start();
//		}

		new Thread(new Runnable() {

			public void run() {
				test.set();
			}
		}, "写线程").start();
		new Thread(new Runnable() {

			public void run() {
				test.get();
			}
		}, "读线程").start();
	}

}
