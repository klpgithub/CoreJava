package com.sys.thread.producer;

public class Producer extends Thread {

	// 每次生产的产品数量
	private int num;

//	所在的仓库
	private Storage storage;

	public Producer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		produce(num);
	}

	public void produce(int num) {
		storage.produce(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

}
