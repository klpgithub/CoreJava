package com.sys.thread.synchron.demo1;

public class DemoA extends Thread {

	private String msg;

	public DemoA(String msg) {
		super();
		this.msg = msg;
	}

	public synchronized void print(String string) {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(string);
		}
	}

	@Override
	public void run() {
		print(msg);
	}

}
