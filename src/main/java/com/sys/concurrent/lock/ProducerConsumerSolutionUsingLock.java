package com.sys.concurrent.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock和Condition实现【生产者-消费者】 Created by klp on 2018年8月24日下午5:24:29.
 */
public class ProducerConsumerSolutionUsingLock {

	static class ProducerConsumer {

		private static final int CAPACITY = 3;
		private final Queue<Integer> queue = new LinkedList<Integer>();
		private final Random random = new Random();

		private final ReentrantLock lock = new ReentrantLock();
		private final Condition bufferNotFull = lock.newCondition();
		private final Condition bufferNotEmpty = lock.newCondition();

		public void put() throws InterruptedException {
			lock.lock();
			try {
				while (true) {
					while (queue.size() == CAPACITY) {
						System.out.println("Buffer is full ,waiting ...");
						bufferNotEmpty.await();
					}
					int num = random.nextInt();
					boolean isAdd = queue.offer(num);
					System.out.println("added " + num + " into queue");
					if (isAdd) {
						bufferNotFull.signalAll();
					}
				}
			} finally {
				lock.unlock();
			}
		}

		public void get() throws InterruptedException {
			lock.lock();
			try {
				while (true) {
					while (queue.size() == 0) {
						System.out.println("buffer is empty , waiting ...");
						bufferNotFull.await();
					}
					Integer num = queue.poll();
					if (num != null) {
						System.out.println("consumed " + num + " from queue");
						bufferNotEmpty.signalAll();
					}

				}
			} finally {
				lock.unlock();
			}
		}
	}

	static class Producer implements Runnable {

		private ProducerConsumer producerConsumer;

		public Producer(ProducerConsumer producerConsumer) {
			this.producerConsumer = producerConsumer;
		}

		public void run() {
			try {
				producerConsumer.put();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Consumer implements Runnable {

		private ProducerConsumer producerConsumer;

		public Consumer(ProducerConsumer producerConsumer) {
			this.producerConsumer = producerConsumer;
		}

		public void run() {
			try {
				producerConsumer.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		ProducerConsumer producerConsumer = new ProducerConsumer();

		new Thread(new Producer(producerConsumer)).start();
		new Thread(new Consumer(producerConsumer)).start();

	}

}
