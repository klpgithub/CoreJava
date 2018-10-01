package com.sys.thread.producer;

public class Test {

	public static void main(String[] args) {
		Storage storage = new Storage();

		Producer p1 = new Producer(storage);
		Producer p2 = new Producer(storage);
		Producer p3 = new Producer(storage);
		Producer p4 = new Producer(storage);
		Producer p5 = new Producer(storage);

		Consumer c1 = new Consumer(storage);
		Consumer c2 = new Consumer(storage);
		Consumer c3 = new Consumer(storage);

		p1.setNum(10);
		p2.setNum(40);
		p3.setNum(50);
		p4.setNum(10);
		p5.setNum(90);

		c1.setNum(50);
		c2.setNum(50);
		c3.setNum(50);

		c1.start();
		c2.start();
		c3.start();
		
		
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		
		

	}

}
