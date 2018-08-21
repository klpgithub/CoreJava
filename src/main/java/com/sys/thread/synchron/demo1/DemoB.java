package com.sys.thread.synchron.demo1;

public class DemoB extends Thread{

	private DemoA demoA;

	public DemoB(DemoA demoA) {
		super();
		this.demoA = demoA;
	}	
	
	@Override
	public void run() {
		demoA.print("B");
	}
}
