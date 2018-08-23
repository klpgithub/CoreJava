package com.sys.thread.threadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class MyThreadFactory {

	private static final ExecutorService executor = new ThreadPoolExecutor(1,
			Runtime.getRuntime().availableProcessors(), 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),
			Executors.defaultThreadFactory());

	public void sendTask() {
		Runnable task = new Runnable() {

			public void run() {
				try {
					Thread.sleep(500);
					System.out.println("任务执行结束.....");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		executor.submit(task);
	}

	@Test
	public void testSendTask() {
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
