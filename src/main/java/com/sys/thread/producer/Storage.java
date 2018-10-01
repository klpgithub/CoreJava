package com.sys.thread.producer;

import java.util.LinkedList;

public class Storage {

	// 仓库最大存储量
	private final int MAX_SIZE = 200;

	// 仓库存储的载体
	private LinkedList<Object> list = new LinkedList<>();

	// 生产num个产品
	public void produce(int num) {
		synchronized (list) {
			// 如果仓库剩余容量不足
			while (list.size() + num > MAX_SIZE) {
				System.out.println("【要生产的产品数量】:" + num + "\t 【库存量】:" + list.size() + "\t暂时不能执行生产任务!");
				try {
					// 由于条件不足,生产阻塞
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < num; i++) {
				list.add(new Object());
			}
			System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
			// 生产完产品后，通知其他被阻塞的线程
			list.notifyAll();
		}
	}

	// 消费num个产品
	public void consume(int num) {
		synchronized (list) {
			// 仓库存储不足
			while (list.size() < num) {
				System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t暂时不能执行消费任务!");
				try {
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < num; i++) {
				list.remove();
			}
			System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());
			// 消费完后，释放锁，通知其他被阻塞的线程
			list.notifyAll();
		}
	}

	public int getMAX_SIZE() {
		return MAX_SIZE;
	}

	public LinkedList<Object> getList() {
		return list;
	}

	public void setList(LinkedList<Object> list) {
		this.list = list;
	}

}
