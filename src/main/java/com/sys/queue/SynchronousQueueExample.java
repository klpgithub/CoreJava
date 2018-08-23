package com.sys.queue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueExample {

	static class SynchronousQueueProducer implements Runnable {

		protected BlockingQueue<String> blockingQueue;
		final Random random = new Random();

		public SynchronousQueueProducer(BlockingQueue<String> queue) {
			this.blockingQueue = queue;
		}

		public void run() {
			while (true) {
				try {
					String data = UUID.randomUUID().toString();
					System.out.println("PUT : " + data);
					blockingQueue.put(data);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class SynchronousQueueConsumer implements Runnable {
		protected BlockingQueue<String> blockingQueue;

		public SynchronousQueueConsumer(BlockingQueue<String> queue) {
			this.blockingQueue = queue;
		}

		public void run() {
			while (true) {
				try {
					String data = blockingQueue.take();
					System.out.println(Thread.currentThread().getName() + "take() : " + data);
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) {
		final BlockingQueue<String> synchronousQueue = new SynchronousQueue<String>();
		SynchronousQueueProducer producer = new SynchronousQueueProducer(synchronousQueue);
		new Thread(producer).start();
		SynchronousQueueConsumer consumer = new SynchronousQueueConsumer(synchronousQueue);
		new Thread(consumer).start();

		SynchronousQueueConsumer consumer2 = new SynchronousQueueConsumer(synchronousQueue);
		new Thread(consumer2).start();

	}

}
