package com.sys.thread.local;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadLocal简单使用
 * 
 * @author Administrator
 *
 */
public class ThreadLocalTest {

	private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

	public static void main(String[] args) {

		System.out.println(new AtomicInteger());
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread() {
				public void run() {
					threadLocal.set("线程：" + Thread.currentThread().getId());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(threadLocal.get());
				};
			};
			thread.start();
		}

	}

}
