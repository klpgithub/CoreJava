package com.sys.thread.synchron.demo2;

public class DemoC implements Runnable {

	private String msg;

	public DemoC(String msg) {
		super();
		this.msg = msg;
	}

	public synchronized void print1(String string) {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(string);
		}
	}

	public static synchronized void print2(String string) {
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(string);
		}
	}

	public void run() {
		print1(msg);
	}

}
